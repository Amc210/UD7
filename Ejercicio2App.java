import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio2App {

	public static void main(String[] args) {
		//Parte cliente que va a comprar
		//Se completa en el 4
		
		//Creamos el arraylist		
		ArrayList<Integer> caja = new ArrayList<>();
				
		//Llamamos a los metodos
		
		cantProductos(caja);
	}
	
	public static void cantProductos(ArrayList<Integer> caja){
		
		String p =  JOptionPane.showInputDialog("Cuantos productos llevas?");
		int nProducto = Integer.parseInt(p);
		
		for (int i = 0; i < nProducto; i++) {
			String np =  JOptionPane.showInputDialog("Cantidad producto " + (i + 1) + "?");
			int nProductos = Integer.parseInt(np);
			
			JOptionPane.showMessageDialog(null, "Cantidad producto " + (i + 1) + " es: " + nProductos);
		}
	}
}
