package Homework1;

import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MainSingleton extends JFrame {
    JFrame displayZoneFrame;
    RenderEngineSingleton renderEngine;
    PhysicsEngineSingleton physicsEngine;
    DynamicSprite hero;
    GameEngineSingleton gameEngine;  
    Playground playground;

    public MainSingleton() throws Exception {
        super("Howdy, Welcome to the Game!");
        super.setSize(400, 250);
        super.setResizable(false);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Show a message dialog on startup
        JOptionPane.showMessageDialog(this, "Welcome to the Dungeon Crawler!");

        displayZoneFrame = new JFrame("Java Labs");
        displayZoneFrame.setSize(400, 600);
        displayZoneFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        hero = new DynamicSprite(ImageIO.read(new File("Homework1/resources/img/heroTileSheetLowRes.png")), 200, 300, 50, 48);

        physicsEngine = PhysicsEngineSingleton.getInstance();
        renderEngine = RenderEngineSingleton.getInstance();
        
        gameEngine = GameEngineSingleton.getInstance(hero);  

        displayZoneFrame.getContentPane().add(renderEngine);

        playground = new Playground("Homework1/resources/level/level1.txt");
        renderEngine.setRenderList(playground.getSpriteList());
        physicsEngine.setEnvironmentList(playground.getSolidSpriteList());

        Timer renderTimer = new Timer(50, (time) -> renderEngine.update());
        Timer gameTimer = new Timer(50, (time) -> gameEngine.update());
        Timer physicTimer = new Timer(50, (time) -> physicsEngine.update());

        renderTimer.start();
        gameTimer.start();
        physicTimer.start();

        displayZoneFrame.setVisible(true);

        renderEngine.addToRenderList(hero);
        physicsEngine.addToMovingSprite(hero);
        displayZoneFrame.addKeyListener(gameEngine);
    }

    public static void main(String[] args) throws Exception {
        MainSingleton main = new MainSingleton();
    }
}
