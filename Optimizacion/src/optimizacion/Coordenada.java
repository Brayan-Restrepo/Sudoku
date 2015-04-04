/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optimizacion;

/**
 *
 * @author Sergio
 */
public class Coordenada {
   double x;
   double y;
   double z;
  public Coordenada(double x,double y){
   this.x=x;
   this.y=y;
   }
   public Coordenada(double x,double y,double z){
   this.x=x;
   this.y=y;
   this.z=z;
   }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
  
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
   
}
