import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Herramienta {

	private int calcularOpLogicos(String codigo) {
		// con esto metodo cuento cuantos AND y OR hay
		int cantOpLogicos = 0;
		//si no es una cadena vacia necesita sumarse 1
		if (!codigo.isEmpty())
			cantOpLogicos++; 
		final String AND = "&&", OR = "||";
		int indiceOR;
		int indiceAND;
		
		while (!codigo.isEmpty()) {
			indiceAND = codigo.indexOf(AND); // busco la posicion del AND
			indiceOR = codigo.indexOf(OR);// busco la posicion del OR
			int indice = -1;
			if (indiceOR != -1 && indiceAND != -1) { // si hay AND y OR
				if (indiceOR < indiceAND) // me quedo con la posicion del que esta antes
					indice = indiceOR;
				else
					indice = indiceAND;
			} else if (indiceOR != -1 && indiceAND == -1) // si hay OR pero no AND
				indice = indiceOR;
			else if (indiceOR == -1 && indiceAND != -1) // si hay AND pero no OR
				indice = indiceAND;

			if (indice != -1) { // indice tendra la posicion del AND o del OR que esta antes (-1 si no hay)
				cantOpLogicos++;
				codigo = codigo.substring(indice + 2); // me quedo con lo que esta despues del operador logico
			} else
				codigo = "";

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
			if (indiceComentario != -1)
				linea = linea.substring(0, indiceComentario);
			int indiceIf = linea.indexOf("if");
			int indiceWhile = linea.indexOf("while");
			int indiceElse = linea.indexOf("else");
			int indiceCase = linea.indexOf("case");
			int indiceDefault = linea.indexOf("default");
			//si empieza con algun condicional copio la linea 
			if (indiceIf == 0 || indiceWhile == 0 || (indiceElse == 0 && indiceIf != -1) || indiceCase == 0
					|| indiceDefault == 0)
				codigoReal = codigoReal + linea.substring(0) + "\n";
		}

		fr.close();
		return codigoReal;
	}

}
