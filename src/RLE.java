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
                boolean igualAnterior = false;

                if (actual == anterior) {
                    igualAnterior = true;
                }

                if (i == 0) {
                    os.write(actual);
                } else {
                    if (!igualAnterior) {
                        os.write(actual);
                    } else {
                        while (igualAnterior && i+1 < arIs.length) {
                            i++;
                            comptador++;
                            actual = arIs[i];
                            if (actual != anterior) {
                                igualAnterior = false;
                            }
                            anterior = actual;
                        }
                        os.write(anterior);
                        os.write(comptador);
                    }
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
