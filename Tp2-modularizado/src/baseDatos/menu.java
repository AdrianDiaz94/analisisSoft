package baseDatos;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class menu {
	
	public static void ps(String x) {//muestra por pantalla mensajes
		System.out.print(x);
	}

	public static int LeerEntero() {//lee la opcion elegida en el menu
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int ne = 0;
		try {
			ne = Integer.parseInt(línea);
		} catch (Exception e) {
		}
		;
		return (ne);
	}

	public static String LeerCadena() {//lee la informacion ingresada en el ingreso de datos o consultas de informes
		String línea = new String("");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			línea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		double ne = 0;
		return (línea);
	}
	
	
	public static int MostrarMenuInicial() {//muestra menu principal del centro asistencial los pinares
		int op1=0;
		do{
			menu.ps("   .............................................." + "\n");
			menu.ps("   :-:         CENTRO ASISTENCIAL             :-:" + "\n");
			menu.ps("   :-:   >>>> L O S  P I N A R E S   <<<<     :-:" + "\n");
			menu.ps("   :-:  C O N T R O L  D E  P A C I E N T E S :-:" + "\n");
			menu.ps("   :-:........................................:-:" + "\n");
			menu.ps("   :-: 1.  Ingreso de datos                   :-:" + "\n");
			menu.ps("   :-: 2.  Informes                           :-:" + "\n");
			menu.ps("   :-: 3.  Salir                              :-:" + "\n");
			menu.ps("   .............................................." + "\n");
			menu.ps("   ....Elija la opcion deseada: ");
			// ps("\n");
			op1 = menu.LeerEntero();
			if (op1 < 1 || op1 > 3) {
				ps("Debe digitar una opcion del menu" + "\n");
				}
		} while (op1 > 3 && op1 < 1);
		return op1;
	}
	
	
	public static int MostrarMenuIngresoDatos() {//muestra el menu para el ingreso de datos
		int op2=0;
		do {
			ps("   ..............................................." + "\n");
			ps("   :-: -I N G R E S O  D E  P A C I E N T E S- :-:" + "\n");
			ps("   :-:.........................................:-:" + "\n");
			ps("   :-: 1.  Datos del paciente                  :-:" + "\n");
			ps("   :-: 2.  Situacion del paciente              :-:" + "\n");
			ps("   :-: 3.  Datos del medico                    :-:" + "\n");
			ps("   :-: 4.  vOLVER                              :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");

			op2 = LeerEntero();

			if (op2 < 1 || op2 > 4) {
				ps("Debe digitar una opcion del menu" + "\n");
			}
		} while (op2 < 1 || op2 > 4);
		return op2;
	}
	
	
	public static int MostrarMenuInformes() {// muestra menu para la consulta de informes
		int op2=0;
		do {
			ps("   ..............................................." + "\n");
			ps("   :-:  C O N T R O L  D E  P A C I E N T E S  :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   :-:           - I N F O R M E S -           :-:" + "\n");
			ps("   :-:.........................................:-:" + "\n");
			ps("   :-: 1. Listado de pacientes por medico      :-:" + "\n");
			ps("   :-: 2. Enfermedades que atiende cada medico :-:" + "\n");
			ps("   :-: 3. Anterior                             :-:" + "\n");
			ps("   ..............................................." + "\n");
			ps("   ....Elija la opcion deseada: ");
			op2 = LeerEntero();
			if (op2 < 1 || op2 > 3) {
				ps("Seleccione una de las opciones del menu" + "\n");
			}
		} while (op2 < 1 || op2 > 3);
		return op2;
	}
	
	
}
