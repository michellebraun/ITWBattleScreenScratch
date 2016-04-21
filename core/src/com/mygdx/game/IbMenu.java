package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by michelle on 4/21/2016.
 */
public class IbMenu extends ImageButton.ImageButtonStyle {

    Skin skin = new Skin();
    TextureAtlas taAtlas;

    public IbMenu() {
        taAtlas = new TextureAtlas(Gdx.files.internal("Button.pack"));
        skin.addRegions(taAtlas);
        this.up = skin.getDrawable("buttonpressed01");
        this.down = skin.getDrawable("buttonpressed02");
       /* ImageButton.ImageButtonStyle imageButtonStyle = skin.get( "default", ImageButton.ImageButtonStyle.class );
        ImageButton button = new ImageButton( imageButtonStyle );*/
    }

}
