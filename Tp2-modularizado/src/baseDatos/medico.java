package baseDatos;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class medico {
	String codigoMedico,nombreMedico,especialidad;
	List<paciente> pacientes= new ArrayList<paciente>();
	
	
	public void AgregarInfoMedico () { //Ingresar datos del medico
		DataOutputStream datomed = null;
		String op="";
		try {
			datomed = new DataOutputStream(new FileOutputStream("C:\\datomed.txt"));
			do {

				menu.ps("   ....................................................." + "\n");
				menu.ps("   :-:      - D A T O S   D E L   M E D I C O -      :-:" + "\n");
				menu.ps("   :-:...............................................:-:" + "\n");

				menu.ps("Digite el codigo del medico: ");
				codigoMedico = menu.LeerCadena();
				datomed.writeUTF(codigoMedico);

				menu.ps("Digite el nombre del medico: ");
				nombreMedico = menu.LeerCadena();
				datomed.writeUTF(nombreMedico);

				menu.ps("Digite la especializacion del medico: ");
				especialidad = menu.LeerCadena();
				datomed.writeUTF(especialidad);

				menu.ps("Desea ingresar otro medico? S/N");
				menu.ps("\n");

				op = menu.LeerCadena();

			} while (op.equals("S") || op.equals("s"));
			datomed.close();
		} catch (IOException ioe) {
		}
		;
		
	}
	
	
	
	public void informesMedicos (int opcion) throws IOException{// se realiza las consultas de informes de medicos
		String codtem;// variables auxiliares temporales
		int sw = 0, sw1 = 0;
		String codp = "", codpa = "", nomp = "", nompa = "", codm = "", codme = "", enfp = "", nomm = "", espm = "";// variables
		// usadas
		// en
		// la
		// lectura
		// de
		// datos
		switch (opcion) {
		case 1: //listado de pacientes por medico
			try {
				menu.ps("Digite el codigo del medico que desea consultar: ");
				codtem = menu.LeerCadena();
				DataInputStream datomed = null;
				datomed = new DataInputStream(new FileInputStream("C:\\datomed.txt"));
				sw = 1;
				while (sw != 0) {
					try {
						codm = datomed.readUTF();
						nomm = datomed.readUTF();
						espm = datomed.readUTF();

					} catch (EOFException e) {
						sw = 0;
					}

					if (codm.equals(codtem)) // compara el codigo extraido de la
												// tabla "datomed" con el codigo
												// digitado
					{
						menu.ps("::: El medico " + nomm + " atiende a los siguientes pacientes: " + "\n");
						DataInputStream situpac = null;
						situpac = new DataInputStream(new FileInputStream("C:\\situpac.txt"));

						sw = 1;
						while (sw != 0) {
							try {
								codp = situpac.readUTF();
								codme = situpac.readUTF();
								enfp = situpac.readUTF();

								if (codme.equals(codtem)) // compara el codigo medico de la
															// tabla "datomed" con el de la
															// tabla "situpac"
								{
									DataInputStream datopac = null;
									datopac = new DataInputStream(
											new FileInputStream("C:\\datopac.txt"));

									sw1 = 1;
									while (sw1 != 0) {
										try {
											codpa = datopac.readUTF();
											nompa = datopac.readUTF();

											if (codpa.equals(codp)) // compara el codigo del
																	// paciente de la tabla "situpac"
																	// con el codigo del paciente de
																	// la tabla "datopac"
											{
												menu.ps("::: Paciente: " + nompa + "\n");
											}
										} catch (EOFException e) {
											sw1 = 0;
										}
									}
								}
							} catch (EOFException e) {
								sw = 0;
							}
						}
					}
				}

			} catch (IOException ioe) {
			}
			;
			break;

		case 2: //enfermedades que atiende cada medico

			menu.ps("Digite el codigo del medico que desea consultar: ");
			codtem = menu.LeerCadena();

			DataInputStream datomed = null;
			datomed = new DataInputStream(new FileInputStream("C:\\datomed.txt"));

			sw1 = 1;
			while (sw1 != 0) {
				try {
					codm = datomed.readUTF();
					nomm = datomed.readUTF();
					espm = datomed.readUTF();

					if (codm.equals(codtem)) // compara el codigo digitado
												// con el codigo del medico de la
												// tabla "datomed"
					{
						menu.ps("El medico " + nomm + " trata las siguientes enfermedades:" + "\n");

						DataInputStream situpac = null;
						situpac = new DataInputStream(new FileInputStream("C:\\situpac.txt"));

						sw = 1;
						while (sw != 0) {
							try {
								codp = situpac.readUTF();
								codme = situpac.readUTF();
								enfp = situpac.readUTF();

								if (codtem.equals(codme)) // compara el codigo del medico
															// de la tabla "datomed"
															// con el codigo del medico en la
															// tabla "situpac"

								{
									menu.ps(">>>> " + enfp + "\n");
								}
							} catch (EOFException e) {
								sw = 0;
							}
						}
					}
				} catch (EOFException e) {
					sw1 = 0;
				}
			}
			break;
		}
		
	}

}
