package com.florent.f1game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.florent.f1game.F1Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Projet F1"; 
		config.foregroundFPS = 60;
		config.width = F1Game.V_WIDTH;
        config.height = F1Game.V_HEIGHT;
        config.resizable = false;
		new LwjglApplication(new F1Game(), config);
	}
}
