
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lector {

    public void eliminarComentario(String string) {
        int indiceComentario = string.indexOf("//");
        if (indiceComentario != -1) {
            string = string.substring(0, indiceComentario);
        }
    }

    public ArrayList<String> getMethodsNames(String path) throws FileNotFoundException, IOException {
        ArrayList<String> reservedNames;
        reservedNames = new ArrayList<String>(Arrays.asList("if", "while", "for", "do", "else","switch"));

        ArrayList<String> methodsNames = new ArrayList<String>();

        String bigLine = "";
        FileReader fileReader = new FileReader(path);
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replaceAll("\n", "");
                bigLine = bigLine.concat(line);
            }

            String patternString = "[^\\)\\(\\{\\}\\t]+\\s([a-z][a-zA-Z0-9]*)\\s*\\(";
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(bigLine);

            while (matcher.find()) {
                if (!reservedNames.contains(matcher.group(1))) {
                    methodsNames.add(matcher.group(1));
                }
            }
        }

        return methodsNames;

    }
}
