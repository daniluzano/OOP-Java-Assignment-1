package Homework1;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite implements Displayable{
    private Image image;
    private double x, y;
    private double height, width;

    public Sprite(Image image, double x, double y, double height, double width) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Image getImage() {
        return image;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getX() {
      return x;
    }

    public double getY() {
      return y;
    }

    public void setX(double newX) {
        this.x = newX;
    }
  
    public void setY(double newY) {
        this.y = newY;
    }

    @Override
    public void draw(Graphics g) {
       g.drawImage(this.image, (int)this.x, (int)this.y, (int)this.width, (int)this.height, null);
    }
}
