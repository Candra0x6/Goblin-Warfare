import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * The battlefield in which the player fights
 * 
 * @author Michael
 * @version 10/15/2014
 */
public class Battlefield extends ScrollWorld
{
    /**
     * Constructor for objects of class Battlefield.
     * 
     */
    public Battlefield()
    {    
        super(600, 600, 1, 2500, 2500);
        Greenfoot.setSpeed(50);
        setPaintOrder(Hud.class, HealthBar.class, BorderForest.class, TreeTop.class, Explosion.class, PlayerGunAmmo.class, Player.class);
        int numTrees = 20;
        
        addObject(new BorderForest(), 1250, 1250);
        
        addObject(new CrateSpawner(), 0, 0);
        
        addObject(new HealthBar(), 0, 0);
        addObject(new Hud(), 0, 0);
        addObject(new PlayerGunAmmo(), 0, 0);
        
        //adds machine gun spawners
        addObject(new MachineGunSpawner(), 1250, 0);
        addObject(new MachineGunSpawner(), 1250, 2500);
        addObject(new MachineGunSpawner(), 2500, 1250);
        addObject(new MachineGunSpawner(), 0, 1250);

        
        
        
        //adds trees;
        Random rand = new Random();
        for(int i = 0; i<numTrees; i++){
            int randX = rand.nextInt(1900) + 300; 
            int randY = rand.nextInt(1900) + 300; 
            addObject(new TreeTruck(), randX, randY);
            addObject(new TreeTop(), randX, randY - 10);
        }
      
        addCameraFollower(new Player(), 0, 0);

        

    }
}
