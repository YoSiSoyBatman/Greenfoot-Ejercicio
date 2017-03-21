import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle  extends Actor
{
    private boolean go;
    private int speed;
    private boolean up;
    private String der;
    private String izq;
    
    public Paddle(boolean ap){
        speed=10;
        go=true;
        up=ap;
        if(ap==true){
            der="s";
            izq="a";
        }
        else{
            der="right";
            izq="left";
        }
    }
    public void act() 
    {
        if(go==true){    
            if(Greenfoot.isKeyDown(der)){
                this.setLocation(this.getX()+speed,this.getY());
            }
            if(Greenfoot.isKeyDown(izq)){
                this.setLocation(this.getX()-speed,this.getY());
            }
        }
        else{
            
        }
    }      
}
