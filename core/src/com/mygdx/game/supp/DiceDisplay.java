package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import static com.mygdx.game.views.PlayScreen.playStage;

public class DiceDisplay {

    private static int dicePosX = 265 * 4;
    private static int dicePosY = 240;
    public static Texture tex;
    public static Image diceImage;


    private static void createDiceImage(int dice)
    {
        tex = new Texture(Gdx.files.internal("core/assets/assetsGame/dice" + dice + ".png"));
        diceImage = new Image(tex);
        diceImage.setName("Dice");
        diceImage.setPosition(dicePosX, dicePosY);
        diceImage.setSize(tex.getWidth()/10f,tex.getHeight()/10f);
        diceImage.toBack();
        playStage.addActor(diceImage);
        // Z-Index of an Actor is crucial to get setup after the the Actor has been added in to the stage.
        // This is because the z index sets the position inside the Array of all Actors of the stage.
        diceImage.setZIndex(0);

    }

    private static void removeDiceImage() {
        diceImage.remove();
        diceImage.addAction(Actions.removeActor(diceImage));

    }


    public static void updateDiceImage(int dice)
    {
        for (Actor i: playStage.getActors())
        {
            if (i.getName().equals("Dice"))
            {
                removeDiceImage();
            }
        }
        createDiceImage(dice);
    }
}
