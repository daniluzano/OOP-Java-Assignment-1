package Homework1;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class RenderEngineSingleton extends JPanel implements Engine {
    static RenderEngineSingleton instance;
    private ArrayList<Displayable> renderList;

    private RenderEngineSingleton() {  
        this.renderList = new ArrayList<>();
    }

    public static RenderEngineSingleton getInstance() {
        if (instance == null) {
            instance = new RenderEngineSingleton();
        }
        return instance;
    }

    void setRenderList(ArrayList<Displayable> renderList) {
        this.renderList = renderList;
    }

    public void addToRenderList(Displayable displayable) {
        renderList.add(displayable);
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    
        for (Displayable d : renderList) {
            d.draw(g);
        }
    }
}
