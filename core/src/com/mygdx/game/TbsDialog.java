package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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
    Texture txDialog;
    Fonts fonts;
    BitmapFont dialogFont;

    public TbsDialog(Fonts _fonts) {
        fonts = _fonts;
        dialogFont = fonts.makeFont(0);
        skin.add("default", dialogFont);
        //txDialog = new Texture(Gdx.files.internal("dialog.jpg"));
        taAtlas = new TextureAtlas(Gdx.files.internal("Dialog.jpg"));
        skin.addRegions(taAtlas);
        this.up = skin.getDrawable("button");
        this.down = skin.getDrawable("buttonclicked");
        this.font = dialogFont;
    }
}
