import greenfoot.*;

public class Hud extends ScrollActor {
    private static GreenfootSound backgroundSound;
    private static boolean soundPlayed = false;

    public Hud() {
        // Initialize the sound only once
        if (backgroundSound == null) {
            backgroundSound = new GreenfootSound("backsound.mp3");
            backgroundSound.setVolume(50); // Optional: adjust volume if needed
        }
    }

    public void act() {
        // Check if the player's tank is still alive
        Player tank = getWorld().getObjects(Player.class).get(0);
        
        // Play sound only if it hasn't been played before and tank is alive
        if (!soundPlayed && tank.getHealth() > 0) {
            backgroundSound.playLoop(); // Use playLoop() for continuous background music
            soundPlayed = true;
        }
        
        // Stop sound when tank is dead (health <= 0)
        if (tank.getHealth() <= 0) {
            backgroundSound.stop();
        }
        
        setImage("HUD.png");
        setLocation(300, 300 + 266);
    }
       // Add a static method to stop sound from anywhere
    public static void stopBackgroundMusicStatic() {
        if (backgroundSound != null) {
            backgroundSound.stop();
        }
    }
}