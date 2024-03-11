
package pilhajava;
public class Pilha<T> {
    private int topo;
    private T[] elementos;
    private String teste;
    
    public Pilha(int tamanho){
        elementos =(T[]) new Object[tamanho];
        this.topo = -1;
    }
    public boolean isFull(){
        return topo==elementos.length - 1;//Esse código é o código abaixo simplificado
        /*if(topo==elementos.length - 1){
            return true;
        }else{
            return false;
        }*/
    }
    public boolean isEmpty(){
        return topo == -1;//Esse código é o código abaixo simplificado
        /*if(topo==-1){
            return true
        }else{
            return false;
        }*/
    }
    
    
}
