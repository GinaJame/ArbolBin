

public class ImprimirArbol<T extends Comparable<T>> {

    public void printNodo(arbolBinario<T> arbin) {
        int maxLevel = maxLevel(arbin.getRaiz());

        printNodoInternal(arbin, 1, maxLevel);
    }

    private void printNodoInternal(arbolBinario<T> arbin, int level, int maxLevel) {
        if (arbin.getRaiz()==null)
            return;

        int floor = maxLevel - level;
        int lineas = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int primerosEsp = (int) Math.pow(2, (floor)) - 1;
        int entreEsp = (int) Math.pow(2, (floor + 1)) - 1;

       ImprimirArbol.printWhitespaces(primerosEsp);
        Nodo<T> temp0=arbin.getRaiz();
        for(int i=0;i<arbin.getNumNodos();i++) {
            if (temp0 != null) {
                System.out.print(temp0.getElemento());                
                temp0=temp0.getIzquierda();
            } else {
                System.out.print(" ");
            }

            ImprimirArbol.printWhitespaces(entreEsp);
        }
        System.out.println("");

        for (int i = 1; i <= lineas; i++) {
            Nodo<T> temp= arbin.getRaiz();
            for (int j = 0; j < arbin.getNumNodos(); j++) {
                ImprimirArbol.printWhitespaces(primerosEsp - i);
                if (temp == null) {
                    ImprimirArbol.printWhitespaces(lineas + lineas + i + 1);
                    break;
                }

                if (temp.getIzquierda() != null)
                    System.out.print("/");
                else
                    ImprimirArbol.printWhitespaces(1);

                ImprimirArbol.printWhitespaces(i + i - 1);

                if (temp.getDerecha() != null)
                    System.out.print("\\");
                else
                   ImprimirArbol.printWhitespaces(1);

                ImprimirArbol.printWhitespaces(lineas + lineas - i);
                temp=temp.getDerecha();
            }

            System.out.println("");
        }

        printNodoInternal(arbin, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int maxLevel(Nodo<T> Nodo) {
        if (Nodo == null)
            return 0;

        return Math.max(maxLevel(Nodo.getIzquierda()), maxLevel(Nodo.getDerecha())) + 1;
    }

    
}