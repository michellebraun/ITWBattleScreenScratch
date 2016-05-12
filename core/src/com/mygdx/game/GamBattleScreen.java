package com.mygdx.game;

import com.badlogic.gdx.Game;

public class GamBattleScreen extends Game {
	ScrBattle scrBattle;
	ScrWin scrWin;
	ScrLose scrLose;
	ScrWeapons scrWeapons;
	HealthBar healthBar;
	Fonts fonts;
	TbsMenu tbsMenu;
	TbsDialog tbsDialog;

	public enum GameState {
		BATTLE, WIN, WEAPONS, LOSE
	}

	public GameState currentState;


	public void updateState(){
		if(currentState==GameState.BATTLE){
			setScreen(scrBattle);
		}else if(currentState==GameState.WIN) {
			setScreen(scrWin);
		}else if(currentState==GameState.WEAPONS) {
			setScreen(scrWeapons);
		}else if(currentState==GameState.LOSE) {
			setScreen(scrLose);
		}
	}

	@Override
	public void create() {
		scrBattle = new ScrBattle(this, healthBar, fonts);
		scrWin = new ScrWin(this, fonts);
		scrWeapons = new ScrWeapons(this, scrBattle, fonts);
		scrLose = new ScrLose(this, fonts);
		tbsDialog = new TbsDialog(fonts);
		tbsMenu = new TbsMenu(fonts);
		currentState = GameState.WEAPONS;
		updateState();
	}

	@Override
	public void render() {
		super.render();
	}
}

