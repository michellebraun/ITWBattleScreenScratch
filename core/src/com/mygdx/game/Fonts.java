package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by michelle on 5/11/2016.
 */
public class Fonts extends ApplicationAdapter {

    SpriteBatch batch;
    TextureAtlas buttonAtlas;
    TextButton.TextButtonStyle buttonStyle;
    TextButton button;
    Skin skin;
    BitmapFont textFont,textFontSmall,textFontSmallest;
    Stage stage;

    // I put the all the lines to create the fonts into a method, that can be called from create function
    // however all of these line may be placed straight into the Create method if you wish
    private void createFonts() {
        //True type font is imported
        FileHandle fontFile = Gdx.files.internal("Woods.ttf");
        // A Generator to create the font, can be named anything
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        // a Parameter setter for the generator can be name anything
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        //enter the text parameters you wish to use
        parameter.size = 25;
        parameter.color= Color.BLACK;
        // tells the generator to create a font with the parameters that you set
        textFont = generator.generateFont(parameter);
        // to create a new font simply enter new parameters, it seems only the parameter
        // you wish to change will have to be re-entered for example here the text stays black
        // while the size is being change
        parameter.size=18;
        textFontSmall= generator.generateFont(parameter);
        parameter.size= 10;
        parameter.color= Color.CORAL;
        parameter.shadowColor= Color.LIGHT_GRAY;
        parameter.shadowOffsetX=5;
        parameter.shadowOffsetY=2;
        textFontSmallest= generator.generateFont(parameter);
        generator.dispose();
    }


}
