//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Texture;

import com.sun.opengl.util.BufferUtil;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

public class TextureReader {
    public TextureReader() {
    }

    public static Texture readTexture(String filename) throws IOException {
        return readTexture(filename, false);
    }

    public static Texture readTexture(String filename, boolean storeAlphaChannel) throws IOException {
        BufferedImage bufferedImage;
        if (filename.endsWith(".bmp")) {
            bufferedImage = BitmapLoader.loadBitmap(filename);
        } else {
            bufferedImage = readImage(filename);
        }

        return readPixels(bufferedImage, storeAlphaChannel);
    }

    private static BufferedImage readImage(String resourceName) throws IOException {
        return ImageIO.read(ResourceRetriever.getResourceAsStream(resourceName));
    }

    private static Texture readPixels(BufferedImage img, boolean storeAlphaChannel) {
        int[] packedPixels = new int[img.getWidth() * img.getHeight()];
        PixelGrabber pixelgrabber = new PixelGrabber(img, 0, 0, img.getWidth(), img.getHeight(), packedPixels, 0, img.getWidth());

        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException var9) {
            throw new RuntimeException();
        }

        int bytesPerPixel = storeAlphaChannel ? 4 : 3;
        ByteBuffer unpackedPixels = BufferUtil.newByteBuffer(packedPixels.length * bytesPerPixel);

        for(int row = img.getHeight() - 1; row >= 0; --row) {
            for(int col = 0; col < img.getWidth(); ++col) {
                int packedPixel = packedPixels[row * img.getWidth() + col];
                unpackedPixels.put((byte)(packedPixel >> 16 & 255));
                unpackedPixels.put((byte)(packedPixel >> 8 & 255));
                unpackedPixels.put((byte)(packedPixel >> 0 & 255));
                if (storeAlphaChannel) {
                    unpackedPixels.put((byte)(packedPixel >> 24 & 255));
                }
            }
        }

        unpackedPixels.flip();
        return new Texture(unpackedPixels, img.getWidth(), img.getHeight());
    }

    public static class Texture {
        private ByteBuffer pixels;
        private int width;
        private int height;

        public Texture(ByteBuffer pixels, int width, int height) {
            this.height = height;
            this.pixels = pixels;
            this.width = width;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public ByteBuffer getPixels() {
            return this.pixels;
        }
    }
}
