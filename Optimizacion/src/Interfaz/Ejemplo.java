/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

/**
 *
 * @author Sergio
 */
public class Ejemplo {

    public static void main(String[] args) {
        int j=0;
        for (int i = 0; i < 2; i++) {
           j=i;
          while(j<1){
              
              j++;
              System.out.println("i:"+i);
              System.out.println("j:"+j);
          }
          j=0;
        }
        
   
    }
}
