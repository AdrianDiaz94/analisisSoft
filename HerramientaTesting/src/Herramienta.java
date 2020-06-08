

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Herramienta {

    private ArrayList<String> operadores = new ArrayList<String>(Arrays.asList("||", ";", "(", "+", "&&", ">", "<", "<=", ">=", "==", "*=", "=", "+=", "-=", "++", "%", "{", "--", "/=", "%=", "^", "!"));
    private ArrayList<String> funciones = new ArrayList<String>(Arrays.asList("for", "while","do", "if", "else"));
    private ArrayList<String> reservadas = new ArrayList<String>(Arrays.asList("boolean", ")", "int","void" ,"String", "float", "public", "private", "}", "return", "true", "false"));

    private int calcularOpLogicos(String codigo) {
        // con esto metodo cuento cuantos AND y OR hay
        int cantOpLogicos = 0;
        //si no es una cadena vacia necesita sumarse 1
        if (!codigo.isEmpty()) {
            cantOpLogicos++;
        }
        final String AND = "&&", OR = "||";
        int indiceOR;
        int indiceAND;

        while (!codigo.isEmpty()) {
            indiceAND = codigo.indexOf(AND); // busco la posicion del AND
            indiceOR = codigo.indexOf(OR);// busco la posicion del OR
            int indice = -1;
            if (indiceOR != -1 && indiceAND != -1) { // si hay AND y OR
                if (indiceOR < indiceAND) // me quedo con la posicion del que esta antes
                {
                    indice = indiceOR;
                } else {
                    indice = indiceAND;
                }
            } else if (indiceOR != -1 && indiceAND == -1) // si hay OR pero no AND
            {
                indice = indiceOR;
            } else if (indiceOR == -1 && indiceAND != -1) // si hay AND pero no OR
            {
                indice = indiceAND;
            }

            if (indice != -1) { // indice tendra la posicion del AND o del OR que esta antes (-1 si no hay)
                cantOpLogicos++;
                codigo = codigo.substring(indice + 2); // me quedo con lo que esta despues del operador logico
            } else {
                codigo = "";
            }

        }
        return cantOpLogicos;
    }

    public int calcularCC(String path) throws IOException {
        int cant = 0;
        String codigo = "";
        codigo = this.soloCondicionales(path);
        int cantOp = this.calcularOpLogicos(codigo);
        String[] lineasCodigo = codigo.split("\n");
        int cantCon = lineasCodigo.length;

        cant = cantCon + cantOp;
        return cant;
    }

    public Map<String, Object> getHalstead(String path, ArrayList<String> methodsNames) throws FileNotFoundException, IOException {

        Map<String, Integer> metOperadores = new HashMap<String, Integer>();
        Map<String, Integer> metOperandos = new HashMap<String, Integer>();
        Map<String, Object> resultados = new HashMap<String, Object>();

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {

            if (linea.contains("/*")) {
                while (linea != null && !linea.contains("*/")) {
                    linea = br.readLine();
                }
                linea = br.readLine();
            }

            if (linea != null && !linea.contains("//")) {
                for (String operador : this.operadores) {
                    if (linea.contains(operador)) {
                        int cantidad = countStringInString(operador, linea);
                        if (metOperadores.containsKey(operador)) {
                            metOperadores.put(operador, metOperadores.get(operador) + cantidad);
                        } else {
                            metOperadores.put(operador, countStringInString(operador, linea));
                        }

                        operador = Pattern.quote(operador);
                        linea = linea.replaceAll(operador, " ");
                    }
                }

                for (String funcion : this.funciones) {
                    if (linea.contains(funcion)) {
                        if (metOperadores.containsKey(funcion)) {
                            metOperadores.put(funcion, metOperadores.get(funcion) + 1);
                        } else {
                            metOperadores.put(funcion, 1);
                        }
                        funcion = Pattern.quote(funcion);
                        linea = linea.replaceAll(funcion, " ");
                    }
                }

                for (String reservada : this.reservadas) {
                    if (linea.contains(reservada)) {
                        reservada = Pattern.quote(reservada);
                        linea = linea.replaceAll(reservada, " ");
                    }
                }
                String tabulador = Pattern.quote("\t");
                linea = linea.replaceAll(tabulador, " ");

                String[] split = linea.split(" ");

                for (int i = 0; i < split.length; i++) {
                    if (!split[i].isEmpty() && !methodsNames.contains(split[i])) {
                        String coso = split[i];
                        if (metOperandos.containsKey(coso)) {
                            metOperandos.put(coso, metOperandos.get(coso) + 1);
                        } else {
                            metOperandos.put(coso, 1);
                        }
                    }
                }
            }
        }
        fr.close();
        int fanOut = getFanOut(path, methodsNames);
        metOperadores.put("(", metOperadores.get("(") - 1 -fanOut);

        if (metOperadores.containsKey("for")) {
            int cantidad = metOperadores.get("for");
            metOperadores.put("(", metOperadores.get("(") - cantidad);
            metOperadores.put(";", metOperadores.get(";") - cantidad * 2);
        }
        /*
        metOperadores.keySet().forEach((key) -> {
            System.out.println(key + " - " + metOperadores.get(key)); // hasta acá obtengo el N1
        });
        System.out.println("-----------------------------------------------------");
        metOperandos.keySet().forEach((key) -> {
            System.out.println(key + " - " + metOperandos.get(key)); // hasta acá obtengo el N1
        });*/

        int nUno = 0;
        int nDos = 0;

        for (String key1 : metOperadores.keySet()) {
            nUno = metOperadores.get(key1) + nUno;
        }

        for (String key2 : metOperandos.keySet()) {
            nDos = metOperandos.get(key2) + nDos;
        }
        //System.out.println(nUno+" - ");
        Integer longitud = nUno + nDos;
        float volumen = (float) (longitud * (Math.log(metOperandos.size() + metOperadores.size()) / Math.log(2)));
        float esfuerzo = (float) (volumen / 0.89);

        resultados.put("longitud", longitud);
        resultados.put("volumen", volumen);
        resultados.put("esfuerzo", esfuerzo);

        return resultados;
    }

    private static boolean isNumeric(final String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getFanOut(String path, ArrayList<String> methodsNames) throws FileNotFoundException, IOException {
        int cantidad = -1;
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {
            for (int i = 0; i < methodsNames.size(); i++) {
                if (linea.contains(methodsNames.get(i))) {
                    cantidad++;
                }
            }
        }
        fr.close();

        return cantidad;
    }

    public int getFanIn(String path, String methodName) throws FileNotFoundException, IOException {
        int cantidad = -1;
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String linea;

        while ((linea = br.readLine()) != null) {
            if (linea.contains(methodName)) {
                cantidad++;
            }
        }
        fr.close();
        return cantidad;
    }

    private static int countStringInString(String search, String text) {
        search = Pattern.quote(search);

        Pattern pattern = Pattern.compile(search);
        Matcher matcher = pattern.matcher(text);

        int stringOccurrences = 0;

        while (matcher.find()) {
            stringOccurrences++;
        }
        return stringOccurrences;
    }

    public int[] getTotalLines(String path) throws FileNotFoundException, IOException {
        int[] result = new int[4];
        int totalLines = 0;
        int comentarios = 0;
        int vacio = 0;
        int codigo = 0;
        
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            String tabulador = Pattern.quote("\t");
            linea = linea.replaceAll(tabulador, "");
            totalLines++;
            if (linea.contains("//")) {
                String[] separador = linea.split("//");
                System.out.println(separador.length);
                
                if(separador.length > 1)
                    codigo++;
                
                comentarios++;
            } else if (linea.contains("/*")) {
                comentarios++;
                while ((linea = br.readLine()) != null && !linea.contains("*/")) {
                    if (linea.isEmpty()) {
                        vacio++;
                    } else {
                        comentarios++;
                    }

                    totalLines++;
                }
                comentarios++;
                totalLines++;
            }
            if (linea.isEmpty()) {
                vacio++;
            }else if(!linea.contains("//")){
                codigo++;
            }
        }
        fr.close();
        totalLines = totalLines - 2; // -2 por apertura y cierre

        result[0] = totalLines;//lineas totales
        result[1] = comentarios;//comentarios
        result[2] = codigo-2;//codigo -2 por apertura y cierre
        result[3] = vacio;//vacios

        return result;
    }

    private String soloCondicionales(String path) throws IOException {
        // con este metodo se eliminaran todas las lineas que no empiecen con WHILE,IF , ElSE IF
        //o  SWITCH ( en caso me quedo con los case y el  default , ya que son las distintas opciones)
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        String codigoReal = "";
        String linea;
        while ((linea = br.readLine()) != null) {

            int indiceTab = linea.indexOf("\t");
            int indiceBlanco = linea.indexOf(" ");
            // elimino los \t y los espacios en blanco que esten al inicio de la linea
            while (indiceTab == 0 || indiceBlanco == 0) {
                linea = linea.substring(1);
                indiceTab = linea.indexOf("\t");
                indiceBlanco = linea.indexOf(" ");

            }
            int indiceComentario = linea.indexOf("//");
            //elimino el comentario que tenga la linea
            if (indiceComentario != -1) {
                linea = linea.substring(0, indiceComentario);
            }
            int indiceIf = linea.indexOf("if");
            int indiceWhile = linea.indexOf("while");
            int indiceElse = linea.indexOf("else");
            int indiceCase = linea.indexOf("case");
            int indiceDefault = linea.indexOf("default");
            //si empiezsa con algun condicional copio la linea 
            if (indiceIf !=-1 || indiceWhile !=-1 || (indiceElse !=-1 && indiceIf != -1) || indiceCase == 0
                    || indiceDefault == 0) {
                codigoReal = codigoReal + linea.substring(0) + "\n";
            }

        }

        fr.close();
        return codigoReal;
    }

}
