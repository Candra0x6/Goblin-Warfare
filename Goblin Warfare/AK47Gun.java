import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An enemy tank that is fast but weak
 * 
 * @author Michael
 * @version 14/10/2014
 */
public class AK47Gun extends Enemy
{
    /**
     * The constructer for the enemy set variables
     */
    public AK47Gun(){
        
        setImage("SkeletonEnemy.png");
        
        health = 200;
        speed = 3;
        reloadTime = 5;
        range = 250;
    }

    /**
     * Act - do whatever the EnemyMissileTank wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(health>0){
            turnTowardsTank();
            moveForward();
            shoot();
            makeRoom();
            checkCollision();
            
            if(checkDead()){
                ((Player) getWorld().getObjects(Player.class).get(0)).incrementScore(100);
                getWorld().removeObject(this);
                GreenfootSound deathSound = new GreenfootSound("sounds/death.mp3");
                deathSound.setVolume(100);
                deathSound.play();
            }
        }
    }      

    private void shoot(){
        counter++;
        if(counter > reloadTime){
            counter = 0;
            getWorld().addObject(new EnemyMGun(getRotation()), getGlobalX(), getGlobalY());
        }
    }
}
