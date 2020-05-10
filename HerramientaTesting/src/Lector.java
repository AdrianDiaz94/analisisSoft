import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Lector {

	public Lector(String path) throws FileNotFoundException {
		
		Scanner sc= new Scanner( new File (path));
				
		String codigo="";
		String linea="";
		while(sc.hasNextLine()) {
			linea=sc.nextLine();
			eliminarComentario(linea);
			if(!linea.isEmpty())
			codigo=codigo+linea+"\n";
		}
		sc.close();
		String [] llaveAbierta=codigo.split("/{");
		System.out.println("asd");
		
		
	}

	public void eliminarComentario(String string) 
	{
		int indiceComentario = string.indexOf("//");
		if (indiceComentario != -1)
			string = string.substring(0, indiceComentario);
	}
}
