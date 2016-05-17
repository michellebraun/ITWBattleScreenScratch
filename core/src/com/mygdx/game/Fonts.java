package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import javafx.scene.text.Font;

/**
 * Created by michelle on 5/11/2016.
 */
public class Fonts extends ApplicationAdapter {

    public static BitmapFont makeFont(int nChoose) {
        FileHandle fontFile = Gdx.files.internal("Woods.ttf");
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.color = Color.BLACK;
        if (nChoose == 2) {
            parameter.size = 18;
            parameter.borderColor = Color.WHITE;
            parameter.borderWidth = 3;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        }
        else if (nChoose == 1){
            parameter.size = 30;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        }
        else {
            parameter.size = 18;
            BitmapFont textFont = generator.generateFont(parameter);
            generator.dispose();
            return textFont;
        }
    }
}