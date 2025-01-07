package train;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D; // use this to measure size of fonts to see if it needs wrapping
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.imageio.ImageIO;

import train.Service.CallingPoint;
import train.Service.TrainBoard;

public class BitmapGenerator {

    private static final String globalFont = "SansSerif";

    /*
     * Simple function to save the file to the specified location and will label them approitealy
     */
    public void saveImage(BufferedImage image, String fileName){
        try {
            File outputfile = new File(fileName);
            ImageIO.write(image, "bmp", outputfile);
            System.out.println("Image " + fileName + " created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks to see if the text fits on the screen and if not applies the text shortening tools to ensure that it passes
     * @param text
     * @param width
     * @param g2d
     * @return
     */
    public String textLengthCheck(String text, int width, Graphics2D g2d){
        TextShortening textShortening = new TextShortening();
        FontMetrics metrics = g2d.getFontMetrics();
        int textWidth = metrics.stringWidth(text);
        if (textWidth > width){
            text = textShortening.shortStationName(text);
        }
        textWidth = metrics.stringWidth(text);
        if (textWidth > width){
            text = textShortening.shortCityNames(text);
        }
        return text;
    }
    

    /*
     * Function to draw the board image
     */
    public void drawBoardImage(int width, int height, ArrayList<TrainBoard> trainBoardInformation, int platformNo, int callingLoops, int totalPages) {
        TrainBoard board = trainBoardInformation.get(platformNo);
        String platformNumber = board.getPlatformNo();
        String platformNumberText = platformNumber == null ? board.getDepartureTime() + " Platform --" : board.getDepartureTime() + " Platform " + board.getPlatformNo(); // work out how to ensure it takes up the total amount of space across the screen
        ArrayList<CallingPoint> callingStations = board.getCallingStations(); // array of calling stations

        // Sets up the buffered image ready to draw
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.ORANGE);
        g2d.setFont(new Font(globalFont, Font.PLAIN, 14));
        int x = 0;
        int y = 13;

        try {
            // Displays if the train has been cancelled or the platform it is due to arrive
            g2d.drawString(textLengthCheck(board.getOrigin(),124,g2d),x,y);
            y = 30;
            if (board.getOnTime().equals("Cancelled")){
                g2d.setColor(Color.RED);
                g2d.drawString("Cancelled",x,y);
                g2d.setColor(Color.ORANGE);
            }
            else {
                g2d.drawString(platformNumberText,x,y);
            }

            // displays the destination of the train
            y = 44;
            g2d.drawString(textLengthCheck(board.getDestination(), 124, g2d), x, y);

            g2d.setFont(new Font(globalFont, Font.PLAIN, 9));
            y = 55;
            // displays if the train is on time, delayed or cancelled
            if (board.getOnTime().equals("On time")){
                g2d.setColor(Color.GREEN);
                g2d.drawString("On time", x, y);
            }
            else if (board.getOnTime().equals("Cancelled")){
                // do nothing add a better check for this
            }
            else {
                String delayedIndicator = board.getOnTime().equals("Delayed") ? "" : board.getOnTime(); // Decides whether to display delayed time if available
                g2d.setColor(Color.RED);
                g2d.drawString("Delayed " + delayedIndicator , x, y);
            }

            g2d.setColor(Color.ORANGE);
            g2d.setFont(new Font(globalFont, Font.PLAIN, 9));
            x = 126;
            y = 10;
            // displays the number of calling station pages
            if (board.getOnTime().equals("Cancelled")){
                g2d.setColor(Color.RED);
                g2d.drawString("Was Calling at: Page " + (callingLoops) + " of " + totalPages, x + 1, y);
                g2d.setColor(Color.ORANGE);
            }
            else {
                g2d.drawString("Calling at:       Page " + (callingLoops) + " of " + totalPages, x + 1, y);
            }
            g2d.setFont(new Font(globalFont, Font.PLAIN, 9));
            y = 20;
            // create a duplicate list to loop through
            ArrayList <CallingPoint> callingStationsCopy = new ArrayList<> (callingStations);

            for(CallingPoint station : callingStationsCopy){
                String arrivalTime = Objects.requireNonNullElse(station.getAt(), "");
                String standardTime = board.getOnTime().equals("On Time") ? station.getSt() : Objects.requireNonNullElse(station.getAt(), station.getEt());
                if (board.getOnTime().equals("Cancelled") || station.getSt().equals("On time")) standardTime = "";
                String time = board.getOnTime().equals("Delayed") ? arrivalTime : standardTime;
                String stationName = time + " - " + station.getLocationName();
                g2d.drawString(textLengthCheck(stationName, 128, g2d), x, y);
                y += 10;                          
                callingStations.remove(0);
                if (y == 70){
                    break;
                }
            }
            g2d.setFont(new Font(globalFont, Font.PLAIN, 9));
            y = 200;
            // finally displays the train service it is running on
            g2d.drawString(board.getTrainService(), x,y);

        } finally {
            g2d.dispose();
        }
        // calls the saveImage method to save the image
        saveImage(image, "./data/Board" + callingLoops + ".BMP");
    }

    public void bitMapDrawing(ArrayList<TrainBoard> trainBoardInformation, int platformNo) {
        long startTime = System.currentTimeMillis();
        TrainBoard board = trainBoardInformation.get(platformNo);

        /**
         * Calculates the number of pages needed to display all the calling stations
         */
        int totalStations = board.getCallingStations().size();
        int stationsPerPage = 5;
        int callingPageNos = (int) Math.ceil((double) totalStations / stationsPerPage);

        if (callingPageNos == 0) callingPageNos = 1; // if there are no calling stations it will display the current number of pages
        int pageNumber = 1; // to keep track of the current page number

        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.println("\nGenerating images for " + board.getDestination() + " to " + board.getOrigin() + " on platform " + board.getPlatformNo() + "\n");

        do{
            drawBoardImage(256, 64, trainBoardInformation, platformNo, pageNumber, (int)callingPageNos);
            pageNumber++;
        } while (pageNumber <= callingPageNos); // contiunes to create new images until all calling stations are displayed
        long endTime = System.currentTimeMillis();

        System.out.println("\nFinished generating images. Time taken: " + (endTime - startTime) + "ms");
    }
}