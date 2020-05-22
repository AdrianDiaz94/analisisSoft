
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Gestor {

    public static ArrayList<String> getMethodsNames(String path) throws IOException {
        Lector lector = new Lector();
        ArrayList<String> methodsNames = lector.getMethodsNames(path);
        return methodsNames;
    }

    public static Map<String, Object> getResults(String path,String methodName) throws IOException {
        Map<String, Object> resultadoEvaluacion = new HashMap();
        Herramienta herramienta= new Herramienta();
        Lector l= new Lector();
        l.grabarMetodoEnArchivo(methodName, path);
        
        
        int cc = herramienta.calcularCC(methodName+".java");
        resultadoEvaluacion.put("cc", cc);
        File  file= new File(methodName+".java");
        file.delete();        
        return resultadoEvaluacion;
    }
}
