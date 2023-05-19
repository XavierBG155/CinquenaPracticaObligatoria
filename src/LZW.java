
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class LZW {
    public static void compress(InputStream is, OutputStream os) {
        try {
            int llarg = is.available();
            Map<Character, Integer> diccionari = new HashMap<>();
            for (int i = 0; i < llarg; i++) {
                char c = (char) is.read();
                for (int j = 0; j < 256; j++) {

                    if (!diccionari.containsKey(c)) {
                        diccionari.put(c, i);
                    }
                }
                System.out.println(diccionari);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decompress(InputStream is, OutputStream os) {

    }
}
