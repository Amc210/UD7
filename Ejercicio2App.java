import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio2App {

	public static void main(String[] args) {
		//Parte cliente que va a comprar
		//He echo el arrayList y que pregunte los productos
		//Se completa en el 4 ya que obtienes los precios y las cantidades en el ejercicio 3
		
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
