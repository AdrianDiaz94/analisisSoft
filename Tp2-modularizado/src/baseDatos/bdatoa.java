package baseDatos;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class bdatoa {
	/*********************** MAIN *********************************/
	public static void main(String args[]) throws Exception {
		int op1, op2, op3; // variables de selección usadas en los diferentes menús
		
		do {
			op1 = menu.MostrarMenuInicial();
			
			if (op1 == 1) {// seleción ingreso de datos
				do {
					op2 = menu.MostrarMenuIngresoDatos();
					paciente p= new paciente();
					medico m= new medico();
					switch (op2) {
					case 1: // ingreso de datos, datos del paciente
						p.ingresoDeDatos();
						break;
					
					case 2: // ingreso de datos, situacion del paciente
						p.ingresoDeSituacionDelPaciente();
						break;

					case 3: //ingreso de datos, datos del medico
						m.AgregarInfoMedico();
					}
			} while (op2 != 4);
			} else {
				if (op1 == 2) // seleción informes
				{
					do {
					medico m= new medico();
					op2 = menu.MostrarMenuInformes();
					m.informesMedicos(op2); // informe listado de pacientes o enfermedades que atiende
						
					} while (op2 != 3);
				}
			}
		} while (op1 != 3);
	}
	
}
