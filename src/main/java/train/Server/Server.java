package train.Server;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

import train.BitmapGenerator;
import train.DataHub;

public class Server {

    /*
     * Checks to see if the folder is empty
     */
    public static boolean checkFolder(String folderPath) {
        File folder = new File(folderPath);
        return folder.listFiles().length != 0;
    }

    public static void main(String[] args) {

        // if i just want to print images

        // DataHub dataHub = new DataHub(); 
        // try {
        //     dataHub.createBoard(0);
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


        int port = 9876;
        String folderPath = "./data";  // Path to the folder containing the images

        // Make the folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdir();
        }

        String format = "bmp";  // Image format

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            String localIP;

            // Output the local IP address
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("google.com", 80));
                localIP = socket.getLocalAddress().getHostAddress();
            }
            System.out.println("\n[INFO] - Server is listening on: " + localIP + ":" + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setSoTimeout(5000);
                // BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));  FIX ME LATER
                System.out.println("[INFO] - Client connected from " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                int delayTime = 5000;
                long lastSent = 0;

                try {
                    while (true) {
                        // runs API request and creates new images
                        long currentTime = System.currentTimeMillis();
                        if (currentTime - lastSent >= delayTime) {

                            DataHub dataHub = new DataHub(); 
                            for(File file: folder.listFiles()) 
                                if (!file.isDirectory()){ 
                                    file.delete();
                                }
                            while (!dataHub.createBoard(1)){
                                BitmapGenerator.drawBlueScreen();
                                loopAndSendImagesToBoard(folder, format, clientSocket);
                                Thread.sleep(3600000);
                            }
                            

                            while (checkFolder(folderPath)) {
                                loopAndSendImagesToBoard(folder, format, clientSocket);
 
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

    private static void loopAndSendImagesToBoard(File folder, String format, Socket clientSocket) throws IOException {
        // grabs the first file in the folder
        File[] files = folder.listFiles();
        sortFileByPath(files);
        for (File file : files){    
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("This should be the first file " + files[0].getAbsolutePath());
        String filePath = files[0].getAbsolutePath();

        // Convert the image to a byte array
        byte[] imageData = ImageToByteArray.convertImageToByteArray(new File(filePath), format);

        // Send the image data to the client
        OutputStream out = clientSocket.getOutputStream();
        out.write(imageData);
        out.write("DEADBEEF".getBytes());
        out.flush();
        System.out.println("\nImage " + filePath +" sent to client at " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " (size " + imageData.length + " bytes)");

        // deletes the image in the folder
        files[0].delete();

        System.out.println("Image deleted");
    }

    /* sort testing */
  public static void sortFileByPath(File[] files) {
    if (files == null || files.length <= 1) {
        return; // No sorting needed
    }

    Arrays.sort(files, (file1, file2) -> file1.getName().compareTo(file2.getName()));
}
}


 