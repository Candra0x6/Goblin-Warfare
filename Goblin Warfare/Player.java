import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The tank that the player controls
 * 
 * @author Michael
 * @version 10/6/2014
 */
public class Player extends ScrollActor
{
    //creates variables
    private int myHealth;
    private int mySpeed;
    private int counter;
    private int reloadTime;
    private int score = 0;

    private static final int MOVE_AMOUNT = 3;

    //constructer that initialize variables
    public Player(){
        myHealth = 1000;
        mySpeed = 4;
        counter = 0;
        reloadTime = 32;
    }

    //act method
    public void act() 
    {
        if(myHealth > 0){
            moveAround();
            checkCollisionObject();
            checkCollision();
        }
        else
            Greenfoot.setWorld(new GameOver(score));
    }    

    //moves around
    public void moveAround(){
        if (Greenfoot.getMouseInfo() != null) {
            // flip the character depend on mouse position
            if (Greenfoot.getMouseInfo().getX() > getX()){
                setImage(new GreenfootImage("spr_dig_strip13.png"));
            } else if (Greenfoot.getMouseInfo().getX() < getX()){
                setImage(new GreenfootImage("spr_dig_strip13_flip.png"));
            }
        }
        
        if(Greenfoot.isKeyDown("W"))
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() - MOVE_AMOUNT);
        if(Greenfoot.isKeyDown("A"))
            getWorld().setCameraLocation(getWorld().getCameraX() - MOVE_AMOUNT, getWorld().getCameraY());
        if(Greenfoot.isKeyDown("S"))
            getWorld().setCameraLocation(getWorld().getCameraX(), getWorld().getCameraY() + MOVE_AMOUNT);
        if(Greenfoot.isKeyDown("D"))
            getWorld().setCameraLocation(getWorld().getCameraX() + MOVE_AMOUNT, getWorld().getCameraY());
    }   

    //checks if collsion with an object
    public void checkCollisionObject(){
        Actor obj = getOneIntersectingObject(Objects.class);                 
        if(obj != null){
            if(Greenfoot.isKeyDown("W"))
                getWorld().moveCamera(-MOVE_AMOUNT);
            else if(Greenfoot.isKeyDown("S"))
                getWorld().moveCamera(MOVE_AMOUNT/2);
        }  
    }

    //returns health so that other classes can use it
    public int getHealth(){
        return myHealth;
    }
    
    //checks if comes into collision with a missile
    public void checkCollision(){
       
        
              
        Actor MG = getOneIntersectingObject(EnemyMGun.class);
        if(MG != null){
            myHealth --;
            getWorld().removeObject(MG);
        }
        
        Actor health = getOneIntersectingObject(HealthCrate.class);
        if(health != null){
            myHealth = 1000;
            getWorld().removeObject(health);
        }
        
       
    }
    
    /**
     * Increments score by a set amount
     */
    public void incrementScore(int buff){
        score += buff;
    }
}
