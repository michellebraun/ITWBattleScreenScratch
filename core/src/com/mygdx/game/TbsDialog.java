package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by michelle on 5/10/2016.
 */
public class TbsDialog extends TextButton.TextButtonStyle{
    Skin skin = new Skin();
    TextureAtlas taAtlas;

    public TbsDialog() {
        BitmapFont font = new BitmapFont();
        skin.add("default", font);
        taAtlas = new TextureAtlas(Gdx.files.internal("DialogBox.pack"));
        skin.addRegions(taAtlas);
        this.up = skin.getDrawable("button");
        this.down = skin.getDrawable("buttonclicked");
        this.font = skin.getFont("default");
    }
}
