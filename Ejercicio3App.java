import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio3App {
	
	public static void verProducto (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
		//Preguntamos el nombre
		String producto = JOptionPane.showInputDialog("Nombre del producto?");
		
		//mostramos la informacion 
		//en caso que no exista sera null
		JOptionPane.showMessageDialog(null, "El precio de " + producto + " es: " + pProductos.get(producto));
		JOptionPane.showMessageDialog(null, "La cantidad de " + producto + " es: " + cProductos.get(producto));
	}
	public static void verTodoProducto (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
		
		//mostramos toda la informacion
		JOptionPane.showMessageDialog(null, "Producto-precio " + pProductos.toString());
		JOptionPane.showMessageDialog(null, "Producto/cantidad" + cProductos.toString());
	}
	
	public static void masArticulo (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
		//Preguntamos los datos
		String nProducto = JOptionPane.showInputDialog("Nombre del producto?").toLowerCase();
		int cantProducto = Integer.parseInt(JOptionPane.showInputDialog("Cantidad? "));
		double precioProducto = Double.parseDouble(JOptionPane.showInputDialog("Precio? "));
		
		//Asignamos los valores 
		pProductos.put(nProducto, precioProducto);
		cProductos.put(nProducto, cantProducto);
	}


	public static void main(String[] args) {
		//Vista vendedor
		//Definimos el hashtable
		Hashtable <String, Double> pProductos = new Hashtable <String, Double> ();
		Hashtable <String, Integer> cProductos = new Hashtable <String, Integer> ();
				
		//Precio-producto
		pProductos.put("melocoton", 3.50);
		pProductos.put("pera", 1.95);
		pProductos.put("piña", 4.00);
		pProductos.put("kiwi", 3.95);
		pProductos.put("manzana", 2.25);
		pProductos.put("sandia", 6.00);
		pProductos.put("mandarina", 3.10);
		pProductos.put("naranja", 3.00);
		pProductos.put("nispero", 2.25);
		pProductos.put("melon", 6.00);
		
		//Cantidad-producto
		cProductos.put("melocoton", 35);
		cProductos.put("pera", 95);
		cProductos.put("piña", 40);
		cProductos.put("kiwi", 39);
		cProductos.put("manzana", 25);
		cProductos.put("sandia", 60);
		cProductos.put("mandarina", 30);
		cProductos.put("naranja", 30);
		cProductos.put("nispero", 22);
		cProductos.put("melon", 66);
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer? 1- Ver producto 2 - Ver todos los productos 3 - Añadir producto 4 - Salir"));
		boolean salir = false;
		
		while (!salir) {
			switch (opcion) {
				case 1:
					verProducto(pProductos, cProductos);
					break;
				case 2:
					verTodoProducto(pProductos, cProductos);
					break;
				case 3:
					masArticulo(pProductos, cProductos);
					break;
				case 4:
					salir = true;
					break;
				default:
					System.out.println("Error!!!");
					break;
			}
			if(opcion != 4) {
			opcion = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer? 1- Ver producto 2 - Ver todos los productos 3 - Añadir producto 4 - Salir"));
		
			}
		}
		
	}

}
