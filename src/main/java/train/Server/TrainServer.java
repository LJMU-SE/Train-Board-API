package train.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import train.DataHub;

public class TrainServer {

    static Scanner scan = new Scanner(System.in);

    /**
     * 
     * @param folderPath
     * @return
     */
    public static boolean isFolderEmpty(String folderPath) {
        File folder = new File(folderPath);
        if (folder.listFiles().length != 0) {      
            return true;
        }
        return false;
    }

    /**
     * 
     * @param file
     * @param format
     * @return
     */
    public static byte[] convertImageToByteArray(File file, String format) {
        BufferedImage image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            image = ImageIO.read(file);
            ImageIO.write(image, format, baos);
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    public static void main(String[] args) {
        int port = 9876;
        String folderPath = "C:\\Users\\Chris\\Desktop\\Test\\src\\main\\java\\train\\Images";  // Path to the folder containing the images
        String format = "bmp";  

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setSoTimeout(5000);
                System.out.println("Client connected from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                int delayTime = 5000;
                long lastSent = 0;

                try {
                    while (true) {
                        // runs API request and creates new images
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - lastSent >= delayTime) {

                            DataHub dataHub = new DataHub(); 
                            dataHub.createBoard(1);

                            while (isFolderEmpty(folderPath)) {
                                // grabs the first file in the folder
                                File folder = new File(folderPath);
                                File[] files = folder.listFiles();
                                String filePath = files[0].getAbsolutePath();

                                // Convert the image to a byte array
                                byte[] imageData = convertImageToByteArray(new File(filePath), format);

                                // Send the image data to the client
                                OutputStream out = clientSocket.getOutputStream();
                                out.write(imageData);
                                out.write("DEADBEEF".getBytes());
                                out.flush();
                                System.out.println("Image sent to client at " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " (size " + imageData.length + " bytes)");

                                // deletes the image in the folder
                                files[0].delete();
                                System.out.println("Image deleted");
                                System.out.println(folder.listFiles().length);
 
                                try {
                                    Thread.sleep(10000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            lastSent = currentTime;
                        }
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



     // if i just want to print images

        // DataHub dataHub = new DataHub(); 
        // try {
        //     dataHub.createBoard(1);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }