package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.awt.Font;

/**
 * Created by michelle on 4/20/2016.
 */
public class TbsMenu extends TextButton.TextButtonStyle{
    Skin skin = new Skin();
    TextureAtlas taAtlas;
    Font fonts;
    BitmapFont textFont, textFontSmall, textFontSmallest;

    public TbsMenu(Fonts _fonts) {
        FileHandle fontFile = Gdx.files.internal("Woods.ttf");
        // A Generator to create the font, can be named anything
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        // a Parameter setter for the generator can be name anything
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //enter the text parameters you wish to use
        parameter.size = 25;
        parameter.color = Color.BLACK;
        // tells the generator to create a font with the parameters that you set
        textFont = generator.generateFont(parameter);
        // to create a new font simply enter new parameters, it seems only the parameter
        // you wish to change will have to be re-entered for example here the text stays black
        // while the size is being change
        parameter.size = 18;
        textFontSmall = generator.generateFont(parameter);
        parameter.size = 10;
        parameter.color = Color.CORAL;
        parameter.shadowColor = Color.LIGHT_GRAY;
        parameter.shadowOffsetX = 5;
        parameter.shadowOffsetY = 2;
        textFontSmallest = generator.generateFont(parameter);
        generator.dispose();
        //fonts = _fonts;
        //BitmapFont font = new BitmapFont();
        skin= new Skin();
        //buttonStyle.font= textFont;
        //button= new TextButton("Into The Woods",buttonStyle);
        skin.add("default", textFont);
        taAtlas = new TextureAtlas(Gdx.files.internal("Button.pack"));
        skin.addRegions(taAtlas);
        this.up = skin.getDrawable("buttonpressed01");
        this.down = skin.getDrawable("buttonpressed02");
        this.font = textFont;
    }
}


