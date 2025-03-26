package Homework1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngineSingleton implements Engine, KeyListener {
    private static GameEngineSingleton instance;
    private final DynamicSprite hero;

    private GameEngineSingleton(DynamicSprite hero) { 
        this.hero = hero;
    }

    public static GameEngineSingleton getInstance(DynamicSprite hero) {
        if (instance == null) {
            instance = new GameEngineSingleton(hero);
        }
        return instance;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                hero.setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection(Direction.EAST);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void update() {}
}
