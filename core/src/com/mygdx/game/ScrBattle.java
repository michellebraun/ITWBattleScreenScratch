package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by michelle on 4/20/2016.
 */
public class ScrBattle implements Screen {

    GamBattleScreen gamBattleScreen;
    Texture txEnemy, txHealthBorder, txBackground, txHero,txHeroHealth, txEnemyHealth, txWeapon;
    TbsMenu tbsMenu;
    TbsDialog tbsDialog;
    TbDialog tbDialog;
    Fonts fonts;
    HealthBar healthBar;
    TbMenu tbAttack, tbWeapons;
    SpriteBatch spriteBatch;
    float fEnemyHealth = 200, fHeroHealth = 200;
    Stage stage;
    int nDamage;
    BitmapFont font;
    String sEnemy, sHero;

    public ScrBattle(GamBattleScreen gamBattleScreen, HealthBar _healthBar, Fonts _fonts) {
        this.gamBattleScreen = gamBattleScreen;
        healthBar = _healthBar;
        fonts = _fonts;
    }
    public void damage (int fDamage){
        nDamage = fDamage;
    }
    public void weapon (Texture texture){
        txWeapon = texture;
    }


    @Override
    public void show() {
        stage = new Stage();
        tbsMenu = new TbsMenu(fonts);
        tbsDialog = new TbsDialog(fonts);
        tbAttack = new TbMenu("Attack", tbsMenu);
        tbWeapons = new TbMenu("Change Weapon", tbsMenu);
        tbWeapons.setBounds(270, 0, 260, 100);
        tbAttack.setBounds(0, 0 , 260, 100);
        stage.addActor(tbAttack);
        stage.addActor(tbWeapons);
        font = fonts.makeFont();

        txBackground = new Texture(Gdx.files.internal("woods.jpg"));
        txHero = new Texture(Gdx.files.internal("cinderella.png"));
        txHealthBorder = new Texture(Gdx.files.internal("healthborder.png"));
        txEnemy = new Texture(Gdx.files.internal("witch.png"));

        tbAttack.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                fEnemyHealth = fEnemyHealth - nDamage;
                txEnemyHealth = healthBar.HealthColour(fEnemyHealth);
                System.out.println("Enemy: "+fEnemyHealth);
                sEnemy = "Witch's Health: "+ fEnemyHealth;
                if (fEnemyHealth <= 0) {
                    fEnemyHealth = 200;
                    fHeroHealth = 200;
                    gamBattleScreen.currentState = GamBattleScreen.GameState.WIN;
                    gamBattleScreen.updateState();
                } else {
                    //tbDialog = new TbDialog("Your Health: " +fHeroHealth+" Enemy's Health: " +fEnemyHealth, tbsDialog);
                    //stage.addActor(tbDialog);

                  //Timer:
                    //http://atsiitech.blogspot.ca/2013/09/adding-15-second-timer-to-your-games.html
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                           // tbDialog.remove();
                            int nDamage = (int )(Math.random() * 50 + 10);
                            fHeroHealth = fHeroHealth-nDamage;
                            txHeroHealth = healthBar.HealthColour(fHeroHealth);
                            System.out.println("Hero: "+fHeroHealth);
                            sHero = "Your Health: "+fHeroHealth;
                        }
                    }, 1);
                    if (fHeroHealth <= 0) {
                        fEnemyHealth = 200;
                        fHeroHealth = 200;
                        gamBattleScreen.currentState = GamBattleScreen.GameState.LOSE;
                        gamBattleScreen.updateState();
                    }
                }
                return true;
            }
        });
        txEnemyHealth = healthBar.HealthColour(fEnemyHealth);
        txHeroHealth = healthBar.HealthColour(fHeroHealth);

        tbWeapons.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gamBattleScreen.currentState = GamBattleScreen.GameState.WEAPONS;
                gamBattleScreen.updateState();
                return true;
            }
        });
        sHero = "Your Health: "+fHeroHealth;
        sEnemy = "Witch's Health: "+ fEnemyHealth;
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1,1,1,1);

        stage.act();
        spriteBatch.begin();
        spriteBatch.draw(txBackground, 0, 0);
        spriteBatch.draw(txHealthBorder, 390, 380, 220, 30);
        spriteBatch.draw(txHealthBorder, 0, 380, 220, 30);
        font.draw(spriteBatch, sHero, 0, 450);
        font.draw(spriteBatch, sEnemy, 300, 450);
        spriteBatch.draw(txEnemyHealth,400, 390, fEnemyHealth, 15);
        spriteBatch.draw(txHeroHealth, 10, 390, fHeroHealth, 15);
        spriteBatch.draw(txWeapon, 550, 30, 70, 50);
        spriteBatch.draw(txEnemy, 400, 180, 200, 200);
        spriteBatch.draw(txHero, 0, 170, 200, 200);
        spriteBatch.end();
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
