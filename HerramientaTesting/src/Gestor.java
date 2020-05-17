
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Gestor {

    public static String[] getMethodsNames(String path) throws IOException {
        Lector lector = new Lector();
        String[] methodsNames = lector.getMethodsNames(path);
        return methodsNames;
    }

    public static Map<String, Object> getResults(String path,String methodName) throws IOException {
        Map<String, Object> resultadoEvaluacion = new HashMap();
        Herramienta herramienta= new Herramienta();
        int cc = herramienta.calcularCC(path,methodName);
        resultadoEvaluacion.put("cc", cc);
        //Lector lector = new Lector(codigo);
        return resultadoEvaluacion;
    }
}
