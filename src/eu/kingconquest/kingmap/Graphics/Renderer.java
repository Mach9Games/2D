package eu.kingconquest.kingmap.Graphics;

import eu.kingconquest.kingmap.Cores.Engine;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pW, pH;
    private int[] pixel;

    public Renderer(Engine e) {
        pW = e.getWIDTH();
        pH = e.getHEIGHT();

        pixel = ((DataBufferInt) e.getWindow().getImage().getRaster().getDataBuffer()).getData();

    }

    public void clear(){
        for (int i = 0; i < pixel.length; i++){
            pixel[i] = 0xff000000;
        }
    }
}
