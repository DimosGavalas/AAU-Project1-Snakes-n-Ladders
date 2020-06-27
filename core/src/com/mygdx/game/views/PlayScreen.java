package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.*;


public class PlayScreen implements Screen {

    public static TileBoard3 parent;
    public static Stage playStage;
    private OrthographicCamera camera = new OrthographicCamera();
    private FillViewport viewport = new FillViewport(mapW, mapH, camera);
    public static TiledMap tiledMap = new TmxMapLoader().load("core/assets/assetsGame/board64B.tmx");
    private OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(tiledMap);
    public static Pawn player1;
    public static Pawn player2;
    public static int noOfPlayers;
    public static int mapW = 1408;// Dimensions of TiledMap
    public static int mapH = 1152;



    public PlayScreen(TileBoard3 tileBoard3, Interpolation smooth){

        parent = tileBoard3;
    }


    @Override
    public void show() {

        playStage = new Stage(viewport);
        camera.setToOrtho(false, mapW, mapH);
        camera.update();

        ScoreDisplay.scorePanel();// Setting inside the playStage the players pawns and their score windows
        QuestionPopup.createQuestionWindow(); // Setting inside the playStage our question popup window

    }





    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();
        playStage.act();
        playStage.draw();

       PlayerSwitch.checkAndPlay(); // method for player switch
       DebugPlayer.debugZIndex(); // Debug code Actors Z-Indexes


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        parent.dispose();
        System.gc();
        playStage.dispose();
        tiledMap.dispose();
        renderer.dispose();
        QuestionPopup.texture.dispose();
        DiceDisplay.tex.dispose();
        AnswerButtons.wrong.dispose();
        AnswerButtons.correct.dispose();
        Pawn.question.dispose();
        WindowStyle.backgroundTexture.dispose();
        WindowStyle.backgroundTexture1.dispose();


    }
}
