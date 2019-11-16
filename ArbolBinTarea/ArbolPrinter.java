import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArbolPrinter<T extends Comparable<T>> {

    public void printNodo(Nodo<T> root) {
        int ultimoNivel = niveles(root);
        System.out.println("NIVELES:"+ultimoNivel);

        ImprimirNodo(Collections.singletonList(root), 1, ultimoNivel);
    }

    private void ImprimirNodo(List<Nodo<T>> Nodos, int nivel, int ultimoNivel) {
        if (Nodos.isEmpty() || ElementosNull(Nodos))
            return;

        int piso = ultimoNivel - nivel;
        int endgeLines = (int) Math.pow(2, (Math.max(piso - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (piso)) - 1;
        int betweenSpaces = (int) Math.pow(2, (piso + 1)) - 1;

        ArbolPrinter.espaciosImp(firstSpaces);

        List<Nodo<T>> newNodos = new ArrayList<Nodo<T>>();
        for (Nodo<T> Nodo : Nodos) {
            if (Nodo != null) {
                System.out.print("|"+Nodo.getElemento()+"|");
                newNodos.add(Nodo.getIzquierda());
                newNodos.add(Nodo.getDerecha());
            } else {
                newNodos.add(null);
                newNodos.add(null);
                System.out.print(" ");
            }

            ArbolPrinter.espaciosImp(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < Nodos.size(); j++) {
                ArbolPrinter.espaciosImp(firstSpaces - i);
                if (Nodos.get(j) == null) {
                    ArbolPrinter.espaciosImp(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (Nodos.get(j).getIzquierda() != null)
                    System.out.print("/");
                else
                    ArbolPrinter.espaciosImp(1);

                ArbolPrinter.espaciosImp(i + i);

                if (Nodos.get(j).getDerecha() != null)
                    System.out.print("\\");
                else
                    ArbolPrinter.espaciosImp(1);

                ArbolPrinter.espaciosImp(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        ImprimirNodo(newNodos, nivel + 1, ultimoNivel);
    }

    private static void espaciosImp(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private int niveles(Nodo<T> nodo) {
        if (nodo != null){
            return (Math.max(niveles(nodo.getIzquierda()), niveles(nodo.getDerecha())) + 1);
        }else{
            return 0;
        }
    }

    private boolean ElementosNull(List<Nodo<T>> list) {
        for (Object objecto : list) {
            if (objecto != null)
                return false;
        }

        return true;
    }
}