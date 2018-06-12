package com.florent.f1game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.florent.f1game.F1Game;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Hud implements Disposable{
	public Stage stage;
	private Viewport viewport;
	
	
	private int goldCount;   // int contenant la valeur
	private int fuelCount;

	Label goldCountLabel; 	// Label permettant l'affichage
	Label fuelCountLabel;
	Label goldLabel;
	Label fuelLabel;
	
	
	public Hud(SpriteBatch sb) {
		
		this.goldCount = 0;
		this.fuelCount = 100;
		
		viewport = new FitViewport(F1Game.V_WIDTH, F1Game.V_HEIGHT,new OrthographicCamera());
		stage = new Stage(viewport, sb);
		
		Table table = new Table();
		table.top();
		table.setFillParent(true);
		
		// On defini quel label va ressembler quoi
		
		this.goldCountLabel = new Label(String.format("%06d", this.goldCount), new Label.LabelStyle(new BitmapFont(),Color.WHITE));
		this.fuelCountLabel = new Label(String.format("%03d", this.fuelCount), new Label.LabelStyle(new BitmapFont(),Color.WHITE));
		this.goldLabel = new Label("GOLD", new Label.LabelStyle(new BitmapFont(),Color.WHITE));
		this.fuelLabel = new Label("FUEL", new Label.LabelStyle(new BitmapFont(),Color.WHITE));

		
		// on ajoute les Label
		table.add(goldLabel).expandX().padTop(10);
		table.add(fuelLabel).expandX().padTop(10);
		table.row();
		table.add(goldCountLabel).expandX().padTop(10);
		table.add(fuelCountLabel).expandX().padTop(10);
		
		stage.addActor(table);

	
	}
	
	
	@Override
    public void dispose() { stage.dispose(); }

    
}