import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio1App {
	public static void calcularMedia (ArrayList<Integer> notas, int alumnos, int nNotas) {
		int media = 0, suma = 0;
		
		for (int i = 0; i < alumnos; i++) {
			suma = 0;
			//Mostramos num alumno
			JOptionPane.showMessageDialog(null, "Alumno " + (i + 1));
			for (int j = 0; j < nNotas; j++) {
				//Preguntamos su nota
				String n =  JOptionPane.showInputDialog("Que notas tienes en el examen ?");
				int nota = Integer.parseInt(n);
				//Hace la suma de las notas
				suma += nota;
			}
			//Calcula la media de las notas
			media = suma/nNotas;
			notas.add(media);
			
			//Mostamos
			JOptionPane.showMessageDialog(null, "La media de las notas es: " + notas.get(i));
			//JOptionPane.showMessageDialog(null, "La media de las notas es: " + media);
		}
	}
	
	public static void main(String[] args) {
		//declaracion array y variable
		String alumn =  JOptionPane.showInputDialog("Cuantos alumnos hay? ");
		int alumnos = Integer.parseInt(alumn);
		String not =  JOptionPane.showInputDialog("Cuantas notas hay? ");
		int nNotas = Integer.parseInt(not);
		
		ArrayList<Integer> notas = new ArrayList<>();
		
		calcularMedia(notas, alumnos, nNotas);
	}
}
