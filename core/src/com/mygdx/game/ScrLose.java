package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by michelle on 5/6/2016.
 */
public class ScrLose implements Screen {

    GamBattleScreen gamBattleScreen;
    Fonts fonts;
    TbsMenu tbsMenu;
    TbMenu tbContinue;
    Stage stage;
    SpriteBatch batch;
    String sLose;
    BitmapFont font;

    public ScrLose(GamBattleScreen gamBattleScreen, Fonts _fonts) {
        this.gamBattleScreen = gamBattleScreen;
        fonts = _fonts;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu(fonts);
        tbContinue = new TbMenu("Try Again", tbsMenu);
        tbContinue.setY(0);
        stage.addActor(tbContinue);
        sLose = "You Lose...";
        Gdx.input.setInputProcessor(stage);
        font = fonts.makeFont(1);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);
        batch.begin();
        stage.act();
        font.draw(batch, sLose, 220, 300);
        batch.end();
        stage.draw();
        if(tbContinue.isPressed()){
            gamBattleScreen.currentState = GamBattleScreen.GameState.WEAPONS;
            gamBattleScreen.updateState();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
