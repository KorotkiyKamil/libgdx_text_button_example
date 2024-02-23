package com.text.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class TextButtonTest extends Game {

    Stage stage;
    TextButton.TextButtonStyle style;
    TextButton textButton;
    Skin skin;
    TextureAtlas buttonAtlas;

	@Override
    public void create() {      
        stage = new Stage();
        BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt"));
        //BitmapFont font = new BitmapFont(Gdx.files.internal("lsans-32.fnt"));
        //BitmapFont font = new BitmapFont(Gdx.files.internal("utf-font.fnt"));
        //BitmapFont font = new BitmapFont(Gdx.files.internal("OpenSans-standard.fnt"));
        //BitmapFont font = new BitmapFont(Gdx.files.internal("verdana39distancefield.fnt"));//font.getData().setScale(0.5f);
        Gdx.input.setInputProcessor(stage);
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("buttons.atlas"));
        skin.addRegions(buttonAtlas);
        style = new TextButton.TextButtonStyle();
        style.font = font;
        style.up   = skin.getDrawable("button-up");
        style.down = skin.getDrawable("button-down");
        textButton = new TextButton("Button", style);
        font.getData().setScale(1.0f);
        textButton.setPosition(256, 192);
        stage.addActor(textButton);
    }

    @Override
    public void render() {  
    	Gdx.gl.glClearColor(255, 255, 255, 255);
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }
   @Override
    public void resize(int width, int height) {
    	stage.getViewport().update(width, height, true);
    }
    @Override
    public void dispose() {
    	stage.dispose();
    	buttonAtlas.dispose();
    }
}
