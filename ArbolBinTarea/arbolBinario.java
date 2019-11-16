public class arbolBinario<T extends Comparable<T>>{
    private Nodo<T> raiz;
    private int nodos;
    public Nodo<T> getRaiz(){
        return raiz;
    }
    public void setRaiz(Nodo<T> raiz){
        this.raiz=raiz;
    }
    public int getNumNodos(){
        return nodos;
    }
    public void remove(){
        if(raiz==null){
            System.out.println("No hay nada que remover");
        }else {

        }
    }
    public void insert(T elemento) {
		Nodo<T> nodo= new Nodo<>(elemento);
		if(raiz==null) {
			raiz=nodo;
		}else {
			insertRec(raiz,nodo);
		}
	}
	
	public Nodo<T> insertRec(Nodo<T> temp, Nodo<T> aInsertar) {
		if(temp==null) {
			return aInsertar;
		}else {
			if(aInsertar.getElemento().compareTo(temp.getElemento())>0) {
				raiz.setDerecha(insertRec(temp.getDerecha(),aInsertar));
			}else {
				raiz.setIzquierda(insertRec(temp.getIzquierda(),aInsertar));

			}
			return temp;
		}
	}
    public Nodo<T> FindMax(){
        Nodo<T> temp= raiz;
        while(temp!=null){
            temp=temp.getDerecha();
        }
        return temp;
    }
    public void Find(T elemento){
        if(elemento==raiz.getElemento()){
            System.out.println("Encontrado");
        }
    }
    private void RecorreEnOrden(){
        recorreEnOrden(raiz);
    }
    private void recorreEnOrden(Nodo<T> nodo){
        if(nodo==null){
            System.out.println("No hay nodos");
        }else{    
            recorreEnOrden(nodo.getIzquierda());
            System.out.println("Nodo:" + nodo.getElemento());
            recorreEnOrden(nodo.getDerecha());
        }
    }
    private void RecorreEnPosOrden(){
        recorreEnPosOrden(raiz);
    }
    private void recorreEnPosOrden(Nodo<T> nodo){
        if(nodo==null){
            System.out.println("No hay nodos");
        }else{    
            recorreEnOrden(nodo.getIzquierda());
            recorreEnOrden(nodo.getDerecha());
            System.out.println("Nodo:" + nodo.getElemento());
        }
    }
    private void RecorreEnPreOrden(){
        recorreEnPreOrden(raiz);
    }
    private void recorreEnPreOrden(Nodo<T> nodo){
        if(nodo==null){
            System.out.println("No hay nodos");
        }else{
            System.out.println("Nodo:" + nodo.getElemento()); 
            recorreEnOrden(nodo.getIzquierda());
            recorreEnOrden(nodo.getDerecha());
        }
    }
}