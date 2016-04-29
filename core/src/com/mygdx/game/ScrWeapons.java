package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by michelle on 4/21/2016.
 */
public class ScrWeapons implements Screen {

    ScrBattle scrBattle;
    GamBattleScreen gamBattleScreen;
    TbsMenu tbsMenu;
    String sChoose;
    TbMenu tbBeans, tbKnife, tbShoe, tbBread;
    Stage stage;
    SpriteBatch batch;
    BitmapFont font;
    float fDamage;

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
                fDamage = damageBeans();
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        tbKnife.addListener(new InputListener() {
            //@Override
            public float touchDown(InputEvent event, float x, float y, int pointer, int button, float fMinus) {
                fDamage = damageKnife();
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return fMinus;
            }
        });
        tbShoe.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fDamage = damageShoe();
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        tbBread.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fDamage = damageBread();
                gamBattleScreen.currentState = GamBattleScreen.GameState.BATTLE;
                gamBattleScreen.updateState();
                return true;
            }
        });
        Gdx.input.setInputProcessor(stage);

    }
    public static float damageKnife() {
        float fMinus;
        fMinus = 50;
        return fMinus;
    }
    public static float damageBeans() {
        float fMinus;
        fMinus = 10;
        return fMinus;
    }
    public static float damageBread() {
        float fMinus;
        fMinus = 20;
        return fMinus;
    }
    public static float damageShoe() {
        float fMinus;
        fMinus = 30;
        return fMinus;
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
