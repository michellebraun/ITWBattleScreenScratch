package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by michelle on 4/21/2016.
 */
public class ScrWeapons implements Screen {

    GamBattleScreen gamBattleScreen;
    TbsMenu tbsMenu;
    //float fMinus;
    String sChoose;
    TbMenu tbBeans, tbKnife, tbShoe, tbBread;
    Stage stage;
    SpriteBatch batch;
    BitmapFont font;

    public ScrWeapons(GamBattleScreen gamBattleScreen) {
        this.gamBattleScreen = gamBattleScreen;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        stage = new Stage();
        tbsMenu = new TbsMenu();
        tbBeans = new TbMenu("Beans", tbsMenu);
        tbKnife = new TbMenu("Knife", tbsMenu);
        tbShoe = new TbMenu("Shoe", tbsMenu);
        tbBread = new TbMenu("Bread", tbsMenu);
        tbBeans.setBounds(0, 0, 290, 100);
       // tbBeans.setBackground("beans.png");
        tbKnife.setBounds(0, 200, 290, 100);
        tbShoe.setBounds(300, 0, 290, 100);
        tbBread.setBounds(300, 200, 290, 100);
        stage.addActor(tbBeans);
        stage.addActor(tbKnife);
        stage.addActor(tbBread);
        stage.addActor(tbShoe);

        font = new BitmapFont(Gdx.files.internal("test.fnt"));
        font.setColor(Color.GREEN);
        sChoose = "Choose a Weapon";

        tbBeans.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        boolean b = tbKnife.addListener(new InputListener() {
            //@Override
            public float touchDown(InputEvent event, float x, float y, int pointer, int button, float fMinus) {
                fMinus = 30;
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return fMinus;
            }
        });
        tbShoe.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        tbBread.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        batch.begin();
        stage.act();
        font.draw(batch, sChoose, 190, 380);
        batch.end();
        stage.draw();
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
