package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import static com.mygdx.game.views.PlayScreen.playStage;

public class DebugPlayer {

    public static void debugZIndex(){

        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {

            for (Actor i : playStage.getActors())
            {
                System.out.println(i.getName() + " HAS INDEX " + i.getZIndex());
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {

            DiceDisplay.diceImage.setZIndex(0);
        }
    }
}
