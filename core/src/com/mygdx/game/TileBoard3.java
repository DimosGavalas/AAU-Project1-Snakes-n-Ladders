package com.mygdx.game;

/**
switching between the stages according to the active one
 * as well as the Input Processor
 * */

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.game.views.*;

public class TileBoard3 extends Game {



    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    public PlayScreen playScreen;
    private FinishScreen finishScreen;
    private EndScreen endScreen;

    public static final int LOADINGSCREEN = 0 ;
    public static final int MENU = 1 ;
    public static final int PLAYGAME = 2 ;
    public static final int FINISHGAME = 3 ;
    public static final int ENDGAME = 4 ;

    @Override
    public void create() {

        loadingScreen = new LoadingScreen(this, Interpolation.smooth);
        setScreen(loadingScreen);

    }

    // noOfPlayers variable updated inside menuScreen

    public void changeScreen(int screen, Interpolation interpolation){

        switch(screen){
            case LOADINGSCREEN:

                if(loadingScreen == null) loadingScreen = new LoadingScreen(this,Interpolation.smooth);
                this.setScreen(loadingScreen);
                Gdx.input.setInputProcessor(LoadingScreen.loadingStage);
                LoadingScreen.loadingStage.act();
                System.gc();
                super.dispose();
                break;

            case MENU:

                if(menuScreen == null) menuScreen = new MenuScreen(this, Interpolation.smooth);
                this.setScreen(menuScreen);
                Gdx.input.setInputProcessor(MenuScreen.menuStage);
                MenuScreen.menuStage.act();
                System.gc();
                super.dispose();
                break;

            case PLAYGAME:

                if(playScreen == null) playScreen = new PlayScreen(this, Interpolation.smooth);
                this.setScreen(playScreen);
                Gdx.input.setInputProcessor(PlayScreen.playStage);
                PlayScreen.playStage.act();
                System.gc();
                super.dispose();
                break;

            case FINISHGAME:

                if(finishScreen == null) finishScreen = new FinishScreen(this,Interpolation.SwingOut.smooth);
                this.setScreen(finishScreen);
                Gdx.input.setInputProcessor(FinishScreen.finishStage);
                FinishScreen.finishStage.act();
                System.gc();
                super.dispose();
                break;

            case ENDGAME:

                if(endScreen == null) endScreen = new EndScreen(this,Interpolation.smooth);
                this.setScreen(endScreen);
                Gdx.input.setInputProcessor(EndScreen.endStage);
                EndScreen.endStage.act();
                System.gc();
                super.dispose();
                break;
        }
    }


    @Override
    public void render() {
        super.render();

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void dispose(){
                super.dispose();
                System.gc();
                this.getScreen().dispose();



    }

}
