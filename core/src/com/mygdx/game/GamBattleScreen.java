package com.mygdx.game;

import com.badlogic.gdx.Game;

public class GamBattleScreen extends Game {
	ScrBattle scrBattle;
	ScrWin scrWin;
	ScrWeapons scrWeapons;

	public enum GameState {
		BATTLE, WIN, WEAPONS
	}

	public GameState currentState;


	public void updateState(){
		if(currentState==GameState.BATTLE){
			setScreen(scrBattle);
		}else if(currentState==GameState.WIN) {
			setScreen(scrWin);
		}
		else if(currentState==GameState.WEAPONS) {
			setScreen(scrWeapons);
		}
	}

	@Override
	public void create() {
		scrBattle = new ScrBattle(this);
		scrWin = new ScrWin(this);
		scrWeapons = new ScrWeapons(this);
		currentState = GameState.WEAPONS;
		updateState();
	}

	@Override
	public void render() {
		super.render();
	}
}

