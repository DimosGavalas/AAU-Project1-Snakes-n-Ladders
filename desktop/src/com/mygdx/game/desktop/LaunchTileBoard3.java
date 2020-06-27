package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.TileBoard3;

public class
LaunchTileBoard3
{
    public static void main (String[] args)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 1200;
        config.height = 800;
        config.backgroundFPS = 60;
        config.foregroundFPS = 60;
        new LwjglApplication(new TileBoard3(), config);

    }
}