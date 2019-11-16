public class Main {

	public static void main(String[] args) {
		
		arbolBinario<Integer> arbol= new arbolBinario<>();
        arbol.insert(5);
        arbol.insert(6);
        arbol.insert(9);
        arbol.insert(4);
        arbol.insert(0);
        arbol.insert(3);
        arbol.insert(15);
        arbol.insert(2);
        arbol.insert(7);
        arbol.insert(1);
        arbol.insert(20);

		ArbolPrinter<Integer> ap= new ArbolPrinter<>();
		ap.printNodo(arbol.getRaiz());

	}

}