
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Lector {

    /*public Lector(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        String codigo = "";
        String linea = "";
        while (sc.hasNextLine()) {
            linea = sc.nextLine();
            eliminarComentario(linea);
            if (!linea.isEmpty()) {
                codigo = codigo + linea + "\n";
            }
        }
        sc.close();
        String[] llaveAbierta = codigo.split("/{");
        System.out.println("asd");

    }*/

    public void eliminarComentario(String string) {
        int indiceComentario = string.indexOf("//");
        if (indiceComentario != -1) {
            string = string.substring(0, indiceComentario);
        }
    }

    public String[] getMethodsNames(String path) throws FileNotFoundException, IOException {
        String methodsNames[] = {"getL1","getL2","getL3","tipoDeTriangulo","esTriangulo", "mensajeError"};
        /*FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            
        }
        bufferedReader.close();*/
        return methodsNames;

    }
}
