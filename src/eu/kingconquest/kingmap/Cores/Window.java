package eu.kingconquest.kingmap.Cores;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Window extends JFrame {
    private BufferStrategy bs;
    private BufferedImage image;
    private Canvas canvas;
    private Graphics g;


    public BufferedImage getImage() {
        return image;
    }
    public Canvas getCanvas() {
        return canvas;
    }

    public Window(Engine e){
        createWindow(e);
    }

    private void createWindow(Engine e){
        image = new BufferedImage(e.getWIDTH(), e.getHEIGHT(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension((int)(e.getWIDTH() * e.getSCALE()), (int)(e.getHEIGHT() * e.getSCALE()));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        setTitle(e.getTITLE() + " " + e.getVERSION());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update(){
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }
}
