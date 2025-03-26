package Homework1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite {
    boolean isWalking;
    double speed;
    final int spriteSheetNumberOfColumn;
    int timeBetweenFrame;
    Direction direction;

    public DynamicSprite(Image image, double x, double y, double height, double width) {
        super(image, x, y, height, width);
        this.isWalking = true;
        this.speed = 5;
        this.spriteSheetNumberOfColumn = 10;
        this.timeBetweenFrame = 200;
        this.direction = Direction.SOUTH;
    }

    void setDirection(Direction dir) {
        direction = dir;
    }

    private void move() {
        switch (direction) {
            case NORTH -> {
                setY(getY() - speed);
            }
            case SOUTH -> {
                setY(getY() + speed);
            }
            case EAST -> {
                setX(getX() + speed);
            }
            case WEST -> {
                setX(getX() - speed);
            }
        }
    }

    private boolean isMovingPossible(ArrayList<Sprite> environment) {
        double tempX = getX();
        double tempY = getY();
        switch (direction) {
            case NORTH -> {
                tempY = getY() - speed;
            }
            case SOUTH -> {
                tempY = getY() + speed;
            }
            case EAST -> {
                tempX = getX() + speed;
            }
            case WEST -> {
                tempX = getX() - speed;
            }
        }

        Rectangle2D hitBox = new Rectangle2D.Double(tempX, tempY, getWidth(), getHeight());

        for (Sprite sprite : environment) {
            if (sprite instanceof SolidSprite solid && sprite != this) {
                if (hitBox.intersects(solid.getX(), solid.getY(), solid.getWidth(), solid.getHeight())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void moveIfPossible(ArrayList<Sprite> environment) {
        if (isMovingPossible(environment)) {
            move();
        }
    }

    @Override
    public void draw(Graphics g) {
        int currTime = (int) System.currentTimeMillis();
        Integer index = currTime / timeBetweenFrame % spriteSheetNumberOfColumn;
        Integer attitude = direction.getFrameLineNumber();
        //g.drawImage(getImage(), index*(int)getWidth(), attitude*(int)getHeight(), null);
        g.drawImage(getImage(), (int) getX(), (int) getY(), (int) getX() + (int) getWidth(), (int) getY() + (int) getHeight(),
                    index * (int)getWidth(), attitude * (int) getHeight(),(index + 1) * (int)getWidth(), (attitude + 1) * (int)getHeight(), 
                    null);
    }
}