import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball  extends Actor
{
    private boolean go;
    private int dirX;
    private int dirY;
    private int incX;
    private int incY;
    private int delay;
    
    public Ball(){
        dirX=Greenfoot.getRandomNumber(2);
        dirY=Greenfoot.getRandomNumber(2);
        incX = Greenfoot.getRandomNumber(4)+2;
        incY = Greenfoot.getRandomNumber(4)+2;
        delay=40;
        go=false;
        if(dirX == 0)
        {
            dirX = -1;
        }
        if(dirY == 0)
        {
            dirY = -1;
        }
        
    }
    public void act() 
    {
        int win=0;
        int rad=5;
        PongWorld mundo = (PongWorld)this.getWorld();
        if(go==true){    
            this.setLocation(this.getX()+incX*dirX,this.getY()+incY*dirY);
            
            if(this.isTouching(Paddle.class)){
                if(dirY==-1){
                    dirY=1;
                }
                else{
                    dirY=-1;
                }
            }
            if(this.getY() <= rad || this.getY() >= mundo.getHeight()-rad)
            {
                if(this.getY() <= rad){
                    win=mundo.incDown();
                    mundo.showText("Player Down: "+win,100,mundo.getHeight()-20);
                    if(win==5){
                        mundo.showText("Player Down Wins!!!! ",mundo.getWidth()/2,mundo.getHeight()/2);
                    }
                    else{
                        mundo.addObject(new Ball(), mundo.getWidth()/2, mundo.getHeight()/2);
                    }
                }
                else{
                    win=mundo.incUp();
                    mundo.showText("Player Up: "+win,100,20);
                    if(win==5){
                        mundo.showText("Player Up Wins!!!! ",mundo.getWidth()/2,mundo.getHeight()/2);
                    }
                    else{ 
                        mundo.addObject(new Ball(), mundo.getWidth()/2, mundo.getHeight()/2);
                    }
                }
                mundo.removeObject(this);
            }
            else{
                if(this.getX() <= rad)
                {
                    dirX=1;
                }
                else if(this.getX() >= mundo.getWidth()-rad)
                {
                    dirX=-1;
                }
            }
        }
        else{
            Greenfoot.delay(delay);
            go=true;
        }
    }    
}
