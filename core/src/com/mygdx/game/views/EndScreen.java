package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

import java.util.logging.MemoryHandler;

public class EndScreen implements Screen {

    public static Stage endStage;

    private TileBoard3 parent;
    private Image bravo ;
    private Sound cheering ;
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private Texture tex = new Texture("background.jpg");



    public EndScreen(TileBoard3 tileBoard3, Interpolation circleIn){


        parent = tileBoard3;
        parent = tileBoard3;
        endStage=new Stage();

    }

    @Override
    public void show() {


        Table table  = new Table();
        table.setFillParent(true);
        table.setBackground(new TextureRegionDrawable(new TextureRegion(tex)));
        TextButton mainMenu = new TextButton("Main Menu",skin);
        TextButton exit = new TextButton("Exit",skin);
        table.add(mainMenu).fillX().uniformX();
        table.row().pad(10,0,10,0);
        table.add(exit).fillX().uniformX();
        endStage.addActor(table);

        mainMenu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                parent.changeScreen(TileBoard3.MENU,Interpolation.fade);
                System.gc();


            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            Gdx.app.exit();
            }
        });


    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        endStage.draw();

        update(delta);
    }

    private void update(float delta) {

        endStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

     endStage.getViewport().update(width,height,true);
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
     endStage.dispose();
     skin.dispose();
    }
}
