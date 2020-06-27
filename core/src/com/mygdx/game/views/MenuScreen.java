package com.mygdx.game.views;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.supp.Pawn;

public class MenuScreen implements Screen {
    public static Stage menuStage;
    private TileBoard3 parent;
    private Skin skin = new Skin(Gdx.files.internal("core/assets/assetsGame/skin/glassy-ui.json"));
    private Skin skin1 = new Skin(Gdx.files.internal("core/assets/assetsGame/skin/uiskin.json"));
    private Texture tex = new Texture("core/assets/assetsGame/background.jpg");

    private Sound MUSIC = Gdx.audio.newSound(Gdx.files.internal("core/assets/assetsGame/audio/puzzle.mp3"));
    private Texture volumeTex = new Texture("core/assets/assetsGame/volume.png");
    private Texture volumeTexMute = new Texture("core/assets/assetsGame/mute.png");
    private Drawable drawableVolume = new TextureRegionDrawable(new TextureRegion(volumeTex));
    private Drawable drawableVolumeMute = new TextureRegionDrawable(new TextureRegion(volumeTexMute));


    public MenuScreen(TileBoard3 tileBoard3, Interpolation smooth){
        parent = tileBoard3;
        menuStage = new Stage(new ScreenViewport());

    }


    @Override
    public void show() {



         Table table = new Table();
         table.setFillParent(true);
         TextButton onePlayer = new TextButton("One Player",skin);
         TextButton twoPlayers = new TextButton("Two players", skin);
         TextButton exit = new TextButton("Exit",skin);
         final ImageButton music = new ImageButton(drawableVolume,drawableVolume,drawableVolumeMute);//giving 3 images to the button to be able to                                                                                                          //switch between when button is clicked
         table.setBackground(new TextureRegionDrawable(new TextureRegion(tex)));
         table.add(onePlayer).fillX().uniformX();
         table.row().pad(10,0,10,0);
         table.add(twoPlayers).fillX().uniformX();
         table.row().pad(10,0,10,0);
         table.add(exit).fillX().uniformX();
         table.row().pad(10,0,10,0);
         table.add(music).fillX().uniformX();
         table.row().pad(10,0,10,0);
         table.pack();



        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        onePlayer.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                PlayScreen.noOfPlayers = 1;
                parent.changeScreen(TileBoard3.PLAYGAME, Interpolation.smooth);
            }
        });

        twoPlayers.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                PlayScreen.noOfPlayers = 2;
                parent.changeScreen(TileBoard3.PLAYGAME,Interpolation.smooth);
            }
        });
        menuStage.addActor(table);



        MUSIC.play();
        music.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

// if the button is checked, set to true and it will switch the image to muted

                if (music.isChecked()){
                    music.setChecked(true);
                    MUSIC.stop();
                }
                   else
                       music.setChecked(false);
                       MUSIC.resume();

            }
        });

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        menuStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        menuStage.draw();
    }

    @Override
    public void resize(int width, int height) {

        menuStage.getViewport().update(width, height, true);
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
        menuStage.dispose();
        parent.dispose();
        skin.dispose();
        skin1.dispose();
        tex.dispose();
        MUSIC.dispose();
        volumeTex.dispose();
        volumeTexMute.dispose();
    }
}