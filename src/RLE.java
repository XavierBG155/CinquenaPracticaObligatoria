import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RLE {
    public static void compress(InputStream is, OutputStream os) {
        try {
            int comptador = 0;
            byte[] arIs = is.readAllBytes();
            byte anterior = 0;
            for (int i = 0; i < arIs.length; i++) {
                byte actual = arIs[i];
                boolean esRepeteix = false;
                if (anterior == actual){
                    esRepeteix = true;
                }
                if (esRepeteix) {
                    while (esRepeteix){
                        actual = arIs[i];
                        comptador++;
                        if (actual != anterior){
                            esRepeteix = false;
                        }
                        i++;
                    }
                    os.write(comptador);
                } else {
                    os.write(actual);
                }
                anterior = actual;
                System.out.println(comptador);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decompress(InputStream is, OutputStream os) {

    }
}
