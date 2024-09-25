package train.Server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";  // Replace with the server's IP address if remote
        int serverPort = 9876;
        String savePath = "received_image.bmp";  // Where to save the received image

        try (Socket clientSocket = new Socket(serverAddress, serverPort)) {
            long startTime = System.currentTimeMillis();

            // Send a request to the server
            byte[] sendData = "REQUEST IMAGE".getBytes();
            clientSocket.getOutputStream().write(sendData);

            // Receive the image data from the server
            try (InputStream in = clientSocket.getInputStream();
                 FileOutputStream fos = new FileOutputStream(savePath)) {
                 
                byte[] buffer = new byte[65535];  // Adjust buffer size as needed
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }

                System.out.println("Image received and saved to " + savePath);
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken: " + (endTime - startTime) + "ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}