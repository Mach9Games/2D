package eu.kingconquest.kingmap;

import eu.kingconquest.kingmap.Cores.Engine;

public class Main{

    public static void main(String[] args) {
            GameLaunch();
    }

    private static void GameLaunch() {
        System.out.println("Application Started");
        Engine engine = new Engine();
        engine.start();
    }
}
