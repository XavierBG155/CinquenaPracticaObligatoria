
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {
    public static void compress(InputStream is, OutputStream os) {
        try {
            List<Byte> diccionari = new ArrayList<>();
            byte[] arIs = is.readAllBytes();
            int index = 0;
            byte anterior;
            for (int i = 0; i < arIs.length; i++) {
                byte b = arIs[i];
                index = search(b, diccionari, index);
                if (index == 0) {
                    diccionari.add(b);
                    os.write(index);
                    os.write(b);
                    continue;
                }

                if (diccionari.get(index) == b){

                }
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

    }

    /*private static void passaOP(List<Byte> diccionari, OutputStream os) throws IOException {
        for (byte b : diccionari) {
            os.write(b);
        }
    }*/

    private static int search(int c, List<Byte> dic, int index) {
        for (byte b : dic) {
            if (c == b) return index;
            index++;
        }
        return 0;
    }

    public static void decompress(InputStream is, OutputStream os) {

    }

    /*static class tableEntry {
        int index;
        byte symbol;

        tableEntry(int index, byte symbol) {
            this.index = index;
            this.symbol = symbol;
        }
    }*/
}

