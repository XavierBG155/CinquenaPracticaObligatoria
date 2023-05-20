import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RLE {
    public static void compress(InputStream is, OutputStream os) {
        try {
            int comptador = 0;
            byte[] arBytes = is.readAllBytes();
            byte anterior = 0;
            for (int i = 0; i < arBytes.length; i++) {
                byte actual = arBytes[i];
                boolean estaRepetit = false;
                if (anterior == actual) {
                    estaRepetit = true;
                }else os.write(actual);
                if (estaRepetit) {
                    os.write(anterior);
                    while (estaRepetit) {
                        i++;
                        comptador++;
                        actual = arBytes[i];
                        if (actual != anterior) estaRepetit = false;
                        anterior = actual;
                    }
                    os.write(comptador);
                }
                anterior = actual;

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decompress(InputStream is, OutputStream os) {

    }
}
