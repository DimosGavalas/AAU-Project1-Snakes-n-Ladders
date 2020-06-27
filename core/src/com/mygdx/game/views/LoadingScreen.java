package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class LoadingScreen implements Screen {

    private  TileBoard3 parent;
    public static Stage loadingStage;
    private OrthographicCamera camera = new OrthographicCamera();
    private ScreenViewport viewport = new ScreenViewport() ;
    private Image logo;
    private Sound bip;
    private Texture logoTex = new Texture(Gdx.files.internal("core/assets/assetsGame/logo.png"));




    public LoadingScreen(final TileBoard3 tileBoard3, Interpolation smooth) {

        parent = tileBoard3;
        loadingStage = new Stage(viewport);
        bip = Gdx.audio.newSound(Gdx.files.internal("core/assets/assetsGame/audio/intro.mp3"));
        logo = new Image(logoTex);
//        logo.setOrigin(0,0 );
        logo.setPosition(600, 300);
        loadingStage.addActor(logo);

    }

    @Override
    public void show() {

        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.update();

        logo.addAction(sequence(alpha(0),scaleTo(0f,0f ),
                parallel(   fadeIn(3f, Interpolation.pow2)),
                scaleTo(1f,1f,2f,Interpolation.pow5 ),
                moveTo(600, 300, 1.5f, Interpolation.circleOut),
                fadeOut(1f)));



        loadingStage.addAction(Actions.after(Actions.delay(.1f, new RunnableAction() {
            @Override
            public void run() {
                bip.play();

            }
        })));

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.2f, 0.5f, 0.7f, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport.apply(true);

        loadingStage.addAction(Actions.after(Actions.delay(.1f, new RunnableAction() {
            @Override
            public void run() {
                parent.changeScreen(TileBoard3.MENU,Interpolation.smooth);
            }
        })));

        update(delta);
        loadingStage.draw();

    }


    private void update(float delta) {

        loadingStage.act(delta);

    }


    @Override
    public void resize(int width, int height) {
        loadingStage.getViewport().update(width,height,true);

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
        loadingStage.dispose();
        bip.dispose();
        logoTex.dispose();


    }
}
