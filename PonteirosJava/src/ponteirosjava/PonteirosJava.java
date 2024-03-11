/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ponteirosjava;

/**
 *
 * @author 10414032675
 */
public class PonteirosJava {

   public static void acelera(int minhaVel){
       minhaVel+=5;
       System.out.println("Velocidade funcao: "+minhaVel);
   }
   public static void aceleraCarro(Carro car){
       car.alteraVelocidade(car.velocidadeAtual()+5);
       System.out.println("Velocidade funcao: "+car.velocidadeAtual());
   }
    
    public static void main(String[] args) {
        Carro meuCarro = new Carro();
        //int tamanho;
        //leia(tamanho);
       // int [] vetor = new int[tamanho];
        //int vet[10];
        //System.out.println("ID meuCarro: "+meuCarro);
        meuCarro.alteraVelocidade(50);
         int minhaVelocidade = meuCarro.velocidadeAtual();
        System.out.println("Velocidade atual: "+minhaVelocidade);
        
        acelera(minhaVelocidade);
        System.out.println("Velocidade atual: "+minhaVelocidade);
        aceleraCarro(meuCarro);
        System.out.println("Velocidade Atual: "+meuCarro.velocidadeAtual());
    }
   
    
}
