package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class BattleScreenScratch extends ApplicationAdapter {
	TextureAtlas taHero;
	Texture txEnemy, txHealth, txHealthBorder;
	Sprite spEnemy;
	Skin skin = new Skin();
	TextureAtlas buttonAtlas;
	TextButton.TextButtonStyle tbsButton;
	TextureRegion trCurrentFrame, trLeft[], trRight[], trUp[], trDown[];
	Animation aniLeft, aniRight, aniUp, aniDown;
	float fStateTime;
	SpriteBatch spriteBatch;
	float HeroX, HeroY, fEnemyHealth, fHeroHealth, HeroSpeed = 50f;
	TextButton tbAttack, tbWeapons;
	Stage stage;


	/*private static Button.ButtonStyle TbsButton(){
		Skin skin = new Skin();
		TextureAtlas buttonAtlas;
		TextButton.TextButtonStyle tbsButton;
		BitmapFont font = new BitmapFont();
		tbsButton= new TextButton.TextButtonStyle();
		skin.add("default", font);
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Button.pack"));
		skin.addRegions(buttonAtlas);
		tbsButton.up = skin.getDrawable("buttonpressed01");
		tbsButton.down = skin.getDrawable("buttonpressed02");
		tbsButton.font = skin.getFont("default");
		return tbsButton;
	}*/
//private void draw(){}

	@Override
	public void create () {
		//TextButton.TextButtonStyle tbsButton = null;
		//TbsButton() = tbsButton;
		stage = new Stage();
		BitmapFont font = new BitmapFont();
		tbsButton= new TextButton.TextButtonStyle();
		skin.add("default", font);
		buttonAtlas = new TextureAtlas(Gdx.files.internal("Button.pack"));
		skin.addRegions(buttonAtlas);
		tbsButton.up = skin.getDrawable("buttonpressed01");
		tbsButton.down = skin.getDrawable("buttonpressed02");
		tbsButton.font = skin.getFont("default");
		tbAttack= new TextButton("Attack",tbsButton);
		tbWeapons = new TextButton("Weapons", tbsButton);
		tbWeapons.setX(270);
		stage.addActor(tbAttack);
		stage.addActor(tbWeapons);

		txHealthBorder = new Texture(Gdx.files.internal("healthborder.png"));
		txHealth = new Texture(Gdx.files.internal("red.png"));
		txEnemy = new Texture(Gdx.files.internal("witch.png"));
		/*spEnemy = new Sprite(txEnemy, 200, 200, 500, 500);
		spEnemy.setPosition(200, 200);
		spEnemy.setRotation(45);
		//stage.addActor(spEnemy);*/

		taHero = new TextureAtlas("Heroinepacked.pack");
		trCurrentFrame = new TextureRegion();
		trLeft = new TextureRegion[3];
		trRight = new TextureRegion[3];
		trUp = new TextureRegion[3];
		trDown = new TextureRegion[3];
		for (int i = 0; i < 3; i++) {
			trLeft[i] = taHero.findRegion("Left" + (i + 1));
			trRight[i] = taHero.findRegion("Right" + (i + 1));
			trUp[i] = taHero.findRegion("Up" + (i + 1));
			trDown[i] = taHero.findRegion("Down" + (i + 1));
		}
		aniRight = new Animation(1f / 4, trRight);
		aniLeft = new Animation(1f / 4, trLeft);
		aniUp = new Animation(1f / 4, trUp);
		aniDown = new Animation(1f / 4, trDown);
		HeroX = 0;
		HeroY = 180;
		fEnemyHealth = 200;
		fHeroHealth = 200;

		tbAttack.addListener(new InputListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				fEnemyHealth = fEnemyHealth - 10;
				System.out.println(fEnemyHealth);
				if (fEnemyHealth == 0){
					txEnemy.dispose();
					spriteBatch.dispose();
					stage.dispose();

				}
				return true;
			}
		});

		spriteBatch = new SpriteBatch();
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glClearColor(1,1,1,1);
		trCurrentFrame = aniDown.getKeyFrame(0);
		fStateTime += Gdx.graphics.getDeltaTime();
		spriteBatch.begin();
		stage.act();
		spriteBatch.draw(txHealthBorder, 390, 380, 220, 30);
		spriteBatch.draw(txHealth, 400, 390, fEnemyHealth, 15);
		spriteBatch.draw(txHealthBorder, 0, 380, 220, 30);
		spriteBatch.draw(txHealth, 0, 390 , fHeroHealth, 15);
		spriteBatch.draw(txEnemy, 400, 180, 200, 200);
		spriteBatch.draw(trCurrentFrame, (int) HeroX, (int) HeroY, 200, 200);
		spriteBatch.end();
		stage.draw();

	}
	}

