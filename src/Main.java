import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Universidad del Valle de Guatemala
 * @author Daniela Batz 19214 
 */
public class Main {
	public static void main (String[] args) {
		Floyd matriz = new Floyd (); //matriz de adyacienia
		matriz.CamCorto(); //Algoritmo floyd que encuentra el camino más corto
		int selec = 1;
		int opcion;
		Scanner scan = new Scanner(System.in);
		
		/**
		 * Ciclo que se realiza mientras que la respuesta del usuario 
		 * no sea 4
		 */
		while (selec!=4) {
			System.out.println("Bienvenido al menu de opciones \nLas opciones son las siguientes:");
			System.out.println("1. Ciudad de Origen-Ciudad de Destino");
			System.out.println("2. Ciudad dentro del grafo");
			System.out.println("3. Modificar grafo");
			System.out.println("4. Salir");
			System.out.println("Ingrese una opcion: ");
			selec = scan.nextInt();
			
			if (selec==1) {
				matriz.CamCorto();
				System.out.println("Ciudad de Origen: ");
				String ciudad1 = scan.next();
				System.out.println("Ciudad de Destino: ");
				String ciudad2 = scan.next();
				
				if (matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)) {
					System.out.println("\nLa distacnia minima es :" + matriz.D.getEdge(ciudad1, ciudad2));
					if (matriz.D.getEdge(ciudad1, ciudad2)!=10000) {
						System.out.println("La ruta es" + ciudad1);
						try {
							matriz.Intermedios(matriz.D.getIndex(ciudad1), matriz.D.getIndex(ciudad2));
						} catch (Exception e) {
							System.out.println("");
						}
						System.out.println(","+ciudad2);
					}
				}
			}
			
			if (selec==2) {
				System.out.println("El centro del grafo es: ");
				matriz.CentGrafo();
			}
			
			if (selec==3) {
				System.out.println("1.Fijar interrupción entre ciudades");
				System.out.println("2. Fijar nueva conexión");
				System.out.println("Ingrese una opción: ");
				opcion=scan.nextInt();
				if (opcion==1) {
					System.out.println("Ciudad de Origen: ");
					String ciudad1 = scan.next();
					System.out.println("Ciudad de Destino: ");
					String ciudad2 = scan.next();
					if (matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)) {
						matriz.D.addEdge(ciudad1, ciudad2, 10000);
						try {
							matriz.a.Write(ciudad1+" "+ciudad2+"10000");
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
				
				if(opcion==2) {
					System.out.println("Ciudad de Origen: ");
					String ciudad1 = scan.next();
					System.out.println("Ciudad de Destino: ");
					String ciudad2 = scan.next();
					System.out.println("Distancia en KM entre las dos ciudades: ");
					int dist=scan.nextInt();
					if (matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)) {
						matriz.D.addEdge(ciudad1, ciudad2, dist);
					}
					else {
						matriz.D.add(ciudad1);
						matriz.D.add(ciudad2);
						matriz.D.addEdge(ciudad1, ciudad2, dist);
					}
					try {
						matriz.a.Write(ciudad1 +" "+ciudad2+" "+dist);
					} catch (IOException ex){
						ex.printStackTrace();
					}
				}
				matriz.CamCorto();
			}
		}
		System.out.println("Fin del programa \nGracias por utilizarnos");
	}
}
