package pila_cola;

import java.util.*;

import javax.swing.JOptionPane;

public class Estructura { //1. sea crean las variables tal y tal y tal para acumular el tamaño limite de la pila, otra vairable para declarar el valor inicial de la cima y otra variable para crear el vector donde se van a almacenar los datos de la pila
	private int item, size = 6, cima=0, frente=0, ultimo=0; 
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stackCola = new Stack<Integer>();
	String botones[]= {"insertar", "Eliminar", "Mostrar", "Retroceder"};
	
	
	
	public void inicio() { //se crea un primer metodo para la pantalla de inicio y de le da al usuario la opcion de elegir si pila o cola
		
		int opc = Integer.parseInt(JOptionPane.showInputDialog("UNIVERSIDAD TECNOLOGICA DE PANAMA\nFACULTAD DE INGENIERIA EN SISTEMAS COMPUTACIONALES\nESTRUCTURA DE DATOS ESTATICOS LINEALES\n\nIntegrantes:\nJuan Carrea\nKevin Mojica\nPula de Leon\nSteven Padilla\nRicardo Lopez\n\nElija el tipo de estructura a usar: \n1. Pila\n2. Cola\n3. Salir"));
		try {
			if(opc==1) {
				opcion();
			}
			else if(opc==2) {
				opcionCola();
			}
			else if(opc==3) {
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
				inicio();
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
			inicio();
		}
	
	}
//***********************INICIO PILA **********************************	
	public int opcion() { //se crea el metodo de la opcion de pila donde se le dara al usuario la opcion de elegir si insertar, eliminar, mostrar o retroceder.
		int operaciones = JOptionPane.showOptionDialog(null, "Seleccione una opción", "PILA", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
		if(operaciones == 0) {
			if(cima == size) {
				JOptionPane.showMessageDialog(null, "PILA LLENA!"); /*Se configura el mensaje de salida si la pila esta llena y el usuario quiere insertar, es decir cuando cima es igual al tamaño */
				opcion();
			}
			else {
				pilainsert();
			}
		}
		
		else if(operaciones == 1) {
			if(cima == 0) {
				JOptionPane.showMessageDialog(null, "PILA VACIA!");
				opcion();
			}
			else {
				int confirm = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
				piladelete();	
				}
				else {
					opcion();
				}
			}
		}
		
		else if(operaciones == 2) {
			mostrar();
		}
		
		else if(operaciones == 3){
			inicio();
		}
		
		return operaciones;
	}
	
	
	public void pilainsert() { /*se crea el metodo para la funcion de insertar, para esta funcion utilizamos el ciclo repetitivo do-while y la funcion en java de .push, 
		esta funcion nos permite insertar un elemento a un arreglo. dentro del ciclo hacemos que cima sea igual a cima + 1 para ir incrementando segun se van insertando los datos a la pila */
		try {	
			item = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero del 1 al 99"));
				if(item>99 || item<1) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero del 1 al 99");
					pilainsert();
				}
				else {
					stack.push(item);
					cima = cima +1;	
				}
			opcion();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
			opcion();
		}
	}
	
	public void piladelete() { /*Se crea el metodo piladelete para eliminar elementos del arreglo, para esto utilizamos la funcion .pop de java que nos permite sacar elementos de un
	arreglo */
		stack.pop();
		cima = cima-1;	
		mostrar();
		opcion();
	}
	
	public void mostrar() { /*Se crea el metodo mostrar para visualizar los elementos de la pila en cualquier momento */
		JOptionPane.showMessageDialog(null, "valor: "+stack+" cima: "+cima);
		opcion();
	}
//***********************FIN PILA **********************************	
	
	
	
//***********************INICIO COLA **********************************	
	public int opcionCola() { //se crea el metodo de la opcion de la cola donde se le dara al usuario la opcion de elegir si insertar, eliminar, mostrar o retroceder.
		int operaciones = JOptionPane.showOptionDialog(null, "Seleccione una opción", "COLA", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, botones, null);
		if(operaciones == 0) {
			if((ultimo == size && frente==1) || (frente == ultimo+1)) {
				JOptionPane.showMessageDialog(null, "COLA LLENA!"); /*Se configura el mensaje de error si la cola esta llena y el usuario quiere insertar, es decir cuando final es igual al tamaño de la cola y frente es igual a 1, o frente es igual a final + 1 */
				opcionCola();
			}
			else {
				colainsert();
			}
		}
		
		else if(operaciones == 1) {
			if((frente == 0 && ultimo == 0)) { //se establecen las condiciones para cuando la cola esta vacia
				JOptionPane.showMessageDialog(null, "COLA VACIA!");
				opcionCola();
			}
			else {
				int confirm = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
				coladelete();	
				}
				else {
					opcionCola();
				}
			}
		}
		
		else if(operaciones == 2) {
			mostrarCola();
		}
		
		else if(operaciones == 3){
			inicio();
		}
		
		return operaciones;
	}
	
	public void colainsert() { /*se crea el metodo para la funcion de insertar en la cola, para esta funcion utilizamos la funcion en java de .push, 
		esta funcion nos permite insertar un elemento a un arreglo. dentro del ciclo hacemos que frente sea igual a 1 y ultimo sea igual a ultimo + 1 para ir incrementando segun se van insertando los datos a la cola */
		try {	
			item = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero del 1 al 99"));
				if(item>99 || item<1) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero del 1 al 99");
					colainsert();
				}
				else {
					stackCola.push(item); //se ingresa un valor a la cola, para esto, la variable frente es igual a 1 y la variable final (en este caso "ultimo") incrementa en 1
					if(frente==0) {
						frente = 1;
					}
					ultimo = ultimo + 1;
					if(ultimo>size) {
						ultimo = 1;
					}
				}
			opcionCola();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un valor valido");
			opcionCola();
		}
		
	}	
	
	public void coladelete() { /*Se crea el metodo coladelete para eliminar elementos del arreglo, para esto utilizamos la funcion .remove de java que nos permite sacar elementos de un
	arreglo */
		if(frente==ultimo) {
			stackCola.remove(0);
			frente = 0;
			ultimo = 0;
			mostrarCola();
			opcionCola();
		}
		else if(frente==size){
			stackCola.remove(0);
			frente = 1;	
			mostrarCola();
			opcionCola();
		}
		else {
			stackCola.remove(0);
			frente = frente+1;	
			mostrarCola();
			opcionCola();
		}

	}
	
	public void mostrarCola() { /*Se crea el metodo mostrar para visualizar los elementos de la pila en cualquier momento */
		JOptionPane.showMessageDialog(null, "valor: "+stackCola+" frente: "+frente+" final: "+ultimo);
		opcionCola();
	}
	
}
