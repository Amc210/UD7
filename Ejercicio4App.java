import java.util.Hashtable;

import javax.swing.JOptionPane;

public class Ejercicio4App {
	public static void clientePaga (String [][] persona, Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
		String nProducto; //nombre producto
		int aux, num;
		double totalBruto = 0, total = 0, totalBrAc = 0;
		final double iva = 0.4;//constante ya que todos los productos tienen un iva igual
		
		for(int i = 0; i < persona.length; i++) {
			//guardamos la cantidad  en una variable pasandolo a int
			num = Integer.parseInt(persona[i][1]);
			//guardamos el nombre del producto en una variable
			nProducto = persona[i][0];
			//Calculamos la suma acumulada de la cantidad de productos
			totalBrAc += num;
			//Calculamos el total bruto
			totalBruto += num * pProductos.get(nProducto);
			//Creamos un auxiliar para poder guardar el num de productos
			aux = cProductos.get(nProducto);
			//borramos el dato anterior ya que le habremos restado lo que compre el cliente
			cProductos.remove(nProducto);
			//Ponemos el nuevo dato actualizado
			cProductos.put(nProducto, (aux-num));
			
		}
		//Calculamos el precio con iva
		total = totalBruto + (totalBruto*(iva/100));
		
		//Mostramos los mensajes
		JOptionPane.showMessageDialog(null, "Precio total bruto: " + totalBruto);
		JOptionPane.showMessageDialog(null, "Precio total con 4% de IVA: " + total);
		JOptionPane.showMessageDialog(null, "Nº de articulos total: " + persona.length);
		nProducto = JOptionPane.showInputDialog("Cuanto dinero te ha dado? ");
		num = Integer.parseInt(nProducto);
		JOptionPane.showMessageDialog(null, "Cambio a devolver: " + (num - total));			
	}
	//Ejercicio 2
	public static void comprarProductos (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
		String p =  JOptionPane.showInputDialog("Cuantos productos llevas?");
		int nProducto = Integer.parseInt(p);
		
		//Hare una matriz de persona que contendra los productos de la compra
		//no se usar mucho el hashtable alguien dijo que haria una matriz y me parecio buena idea
		String [][] persona = new String [nProducto][2];
		
		//preguntamos y asignamos los valores a la posicion
		//posicion 0 para saber que producto es y la 1 para su cantidad
		for (int i = 0; i < nProducto; i++) {
			persona[i][0] =  JOptionPane.showInputDialog("Que producto es? ").toLowerCase();
			persona[i][1] = JOptionPane.showInputDialog("Cantidad del producto " + (i + 1) + " ?");
		}
		//Llamamos al metodo de pagar y pasamos la matriz y los hashtable
		clientePaga(persona, pProductos, cProductos);
	}

	//Parte ejercicio 3
	public static void menuTres (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
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
		public static void verProducto (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
			//Preguntamos el nombre
			String producto = JOptionPane.showInputDialog("Nombre del producto?");
			
			//mostramos la informacion
			//en caso que no exista sera null
			JOptionPane.showMessageDialog(null, "El precio de " + producto + " es: " + pProductos.get(producto));
			JOptionPane.showMessageDialog(null, "La cantidad de " + producto + " es: " + cProductos.get(producto));
		}
		public static void verTodoProducto (Hashtable <String, Double> pProductos, Hashtable <String, Integer> cProductos) {
			
			//mostramos la informacion
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
			
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer? 1- Nuevo cliente 2 - Información productos 3 - Salir"));
			boolean salir = false;
			
			while (!salir) {
				switch (opcion) {
					case 1:
						//menu cliente
						comprarProductos(pProductos, cProductos);
						break;
					case 2:
						//menu tienda ejercicio 3
						menuTres(pProductos, cProductos);
						break;
					case 3:
						salir = true;
						break;
					default:
						System.out.println("Error!!!");
						break;
				}
				if(opcion != 3) {
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Que quieres hacer? 1- Nuevo cliente 2 - Información productos 3 - Salir"));
			
				}
			}

	}

}
