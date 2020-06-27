package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.mygdx.game.views.PlayScreen.noOfPlayers;


public class FinishScreen implements Screen {

    private TileBoard3 parent;
    public static Stage finishStage;
    public TextureRegionDrawable backGroundTex;
    private Image backGround ;
    private OrthographicCamera camera = new OrthographicCamera();
    private ScreenViewport viewport = new ScreenViewport() ;
    private  Skin skin ;
    private Texture tex = new Texture("core/assets/assetsGame/background.jpg");


    public FinishScreen(TileBoard3 tileBoard3, Interpolation smooth) {

        parent = tileBoard3;
        finishStage = new Stage(viewport);
        backGroundTex =  new TextureRegionDrawable(new TextureRegion(tex));
        backGround = new Image(backGroundTex);
        backGround.toBack();
        backGround.setFillParent(true); // to fill the screen with the backGround


    }


    @Override
    public void show() {

        skin = new Skin(Gdx.files.internal("core/assets/assetsGame/skin/glassy-ui.json"));
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.update();
        backGround.setFillParent(true); // to fill the screen with the backGround
        finishStage.addActor(backGround);

        Table table = new Table();
        table.setBackground(backGroundTex);
        table.setPosition(0,0 );

        final TextButton BACK_TO_MENU = new TextButton("BACK TO MENU",skin);
        table.add(BACK_TO_MENU).fillX().uniformX();


        BACK_TO_MENU.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                parent.changeScreen(TileBoard3.MENU,Interpolation.smooth);
                StatisticsDisplay.removeStatsWindow(noOfPlayers);// display stats according to nr of players
                System.gc();
            }

        });

        // 2 actions in sequence
        finishStage.addAction(sequence(new RunnableAction() {
            @Override
            public void run() {
                // method responsible of clearing and removing previous results
                StatisticsDisplay.showStatsWindow(noOfPlayers);

    }
        }, Actions.delay(3f), (new RunnableAction() {
            @Override
            // action to remove the stats from the screen and add a button(BACK TO MENU)

            public void run() {
                finishStage.addActor(BACK_TO_MENU);
                BACK_TO_MENU.addAction(fadeIn(.8f));
                BACK_TO_MENU.setPosition(500,0 );
            }
        }
        )));
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport.apply(true);



        finishStage.addAction(Actions.after(Actions.delay(20f, new RunnableAction() {
            @Override
            public void run() {

                parent.changeScreen(TileBoard3.ENDGAME,Interpolation.smooth);
               StatisticsDisplay.removeStatsWindow(noOfPlayers);
                System.gc();
            }
        })));

        finishStage.act();
        finishStage.draw();
        update(delta);
    }



    private void update(float delta) {
        finishStage.act(delta);
    }

    @Override
    public void resize(int width, int height) {

        finishStage.getViewport().update(width,height,true);
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
        finishStage.dispose();
        skin.dispose();
        tex.dispose();




    }
}
