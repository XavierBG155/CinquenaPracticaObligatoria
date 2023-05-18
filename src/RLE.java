import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RLE {
    public static void compress(InputStream is, OutputStream os) {
        try {
            int comptador = 0;
            int llargF = is.available();
            byte anterior = 0;
            for (int i = 0; i < llargF; i++) {
                byte b = (byte) is.read();
                os.write(b);
                if (b == anterior) {
                    os.write(b);
                    comptador++;
                }else {

                }
                anterior = b;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decompress(InputStream is, OutputStream os) {

    }
}
