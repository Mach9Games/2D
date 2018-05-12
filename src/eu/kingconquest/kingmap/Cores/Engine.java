package eu.kingconquest.kingmap.Cores;

import eu.kingconquest.kingmap.Graphics.Renderer;

public class Engine implements Runnable{

    private Thread mainThread;
    private Window window;
    private Renderer renderer;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;

    private int WIDTH = 320, HEIGHT = 240; //Pixel size
    private float SCALE = 1f; //Canvas Size * Scale
    private String TITLE = "Test Title";
    private String VERSION = "V.0.1 - Engine";

    public int getWIDTH() {
        return WIDTH;
    }
    public int getHEIGHT() {
        return HEIGHT;
    }
    public String getTITLE() {
        return TITLE;
    }
    public float getSCALE() {
        return SCALE;
    }
    public String getVERSION() {
        return VERSION;
    }
    public Window getWindow() {
        return window;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }
    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }
    public void setSCALE(float SCALE) {
        this.SCALE = SCALE;
    }
    public void setVERSION(String VERSION) {
        this.VERSION = VERSION;
    }


    public Engine(){

    }

    public void start(){
        window = new Window(this);
        renderer = new Renderer(this);

        mainThread = new Thread(this);
        mainThread.run();
    }

    public void stop(){

    }

    public void run(){
        running = true;

        boolean render = false;

        //Update Handle
        double firstTime;
        double lastTime = System.nanoTime() / 1e9; // 1 000 000 000.0
        double passedTime;
        double unprocessedTime = 0;

        //FPS Handle
        double frameTime = 0;
        double frames = 0;
        double fps = 0;

        while (running) {
            render = false;

            firstTime = System.nanoTime() / 1e9; // 1 000 000 000.0
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true;

                 //TODO: Update Game
                if (frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }
            if (render) {
                renderer.clear();

                //TODO: Render Game
                window.update();
                frames++;
            }else{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            dispose();
        }
    }

    private void dispose(){
        //TODO: Dispose code
    }
}
