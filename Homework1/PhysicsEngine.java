package Homework1;

import java.util.ArrayList;

public class PhysicsEngine implements Engine {
    ArrayList<DynamicSprite> movingSpriteList;
    ArrayList<Sprite> environment;

    public PhysicsEngine() {
        this.movingSpriteList = new ArrayList<DynamicSprite>();
        this.environment = new ArrayList<Sprite>();
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