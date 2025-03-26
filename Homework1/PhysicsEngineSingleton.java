package Homework1;

import java.util.ArrayList;

public class PhysicsEngineSingleton implements Engine {
    private static PhysicsEngineSingleton instance;
    private ArrayList<DynamicSprite> movingSpriteList;
    private ArrayList<Sprite> environment;

    private PhysicsEngineSingleton() { 
        this.movingSpriteList = new ArrayList<>();
        this.environment = new ArrayList<>();
    }

    public static PhysicsEngineSingleton getInstance() {
        if (instance == null) {
            instance = new PhysicsEngineSingleton();
        }
        return instance;
    }

    void addToMovingSprite(DynamicSprite s) {
        movingSpriteList.add(s);
    }

    public void setEnvironmentList(ArrayList<Sprite> list) {
        environment = list;
    }

    @Override
    public void update() {
        for (DynamicSprite s : movingSpriteList) {
            s.moveIfPossible(environment);
        }
    }
}
