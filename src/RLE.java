import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RLE {
    public static void compress(InputStream is, OutputStream os) {
        try {
            int comptador = 0;
            byte[] arIs = is.readAllBytes();
            boolean igualAnterior = false;
            for (int i = 0; i < arIs.length; i++) {
                byte actual = arIs[i];

                if (i == 0){
                    os.write(actual);
                    continue;
                }
                byte anterior = arIs[i-1];

                //si el comptador arriba a 255, escriurem 255, tornarem comptador a 0 i escriurem el nombre actual
                if (comptador == 255){
                    os.write(comptador);
                    comptador = 0;
                    os.write(actual);
                    igualAnterior = false;
                    continue;
                }
                // Miram si el booleà igualAnterior es true i si el nombre actual es el mateix que teniem.
                //En cas verdader, sumarem comptador
                if (igualAnterior && anterior == actual){
                comptador++;
                continue;
                //si no son iguals l'anterior i l'actual, escriurem el que tinguem al comptador
                    // el nombre actual, que ha de ser diferent a l'anterior
                } else if (igualAnterior) {
                    os.write(comptador);
                    igualAnterior = false;
                    os.write(actual);
                    continue;
                }

                if (anterior == actual){
                    os.write(actual);
                    comptador = 0;
                    igualAnterior = true;
                }else os.write(actual);

            }
            //Aqui ens asegurem de que si acabem amb un nombre que es repeteix, escrivim el comptador,
            //si no acabaria amb el darrer nombre dues vegades sense les repeticions
            if (igualAnterior){
                os.write(comptador);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void decompress(InputStream is, OutputStream os) {

    }
}
