package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by michelle on 6/1/2016.
 */
public class Dialog {

    ScrBattle scrBattle;
    String sLine;

    public Dialog(ScrBattle _scrBattle) {
        scrBattle = _scrBattle;
        FileHandle file = Gdx.files.internal("Dialog.txt");
        sLine = file.readString();
        scrBattle.dialog(sLine);
    }
}
