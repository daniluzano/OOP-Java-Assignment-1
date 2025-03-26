package Homework1;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class RenderEngine extends JPanel implements Engine {
    private ArrayList<Displayable> renderlist;

    public RenderEngine() {
        this.renderlist = new ArrayList<>();
    };

    void setRenderList(ArrayList<Displayable> renderList) {
        this.renderlist = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        renderlist.add(displayable);
    }

    @Override
    public void update() {
       // System.out.println("update method is being executed.");
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Displayable d : renderlist) {
            d.draw(g);
        }
    }
}