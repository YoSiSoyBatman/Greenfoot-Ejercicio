import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PongWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PongWorld  extends World
{
    private int up;
    private int down;
    public PongWorld()
    {    
        // Create a new world with 20x20 cells with a cell size of 10x10 pixels.
        super(700, 500, 1);
        up=0;
        down=0;
        addObject(new Paddle(true), 350, 30);
        addObject(new Paddle(false), 350, 470);
        addObject(new Ball(), this.getWidth()/2, this.getHeight()/2);
        this.showText("Player Down: "+down,100,this.getHeight()-20);
        this.showText("Player Up: "+up,100,20);
        
    }
    public int incUp(){
        up++;
        return up;
    }
    public int incDown(){
        down++;
        return down;
    }
}
