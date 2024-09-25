package train.Server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageToByteArray {
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
}