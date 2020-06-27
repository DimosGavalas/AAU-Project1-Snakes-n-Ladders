package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.mygdx.game.views.PlayScreen.*;

public class PlayerSwitch {

    public static int inactiveInputState = Input.Keys.UNKNOWN;
    public static int activeInputState = Input.Keys.SPACE;
    public static int inputActivationState = activeInputState;
    public static String activePlayer = "player1";

    /** Setting variables (activeInputState and inactiveInputState) for getting the
     * com.badlogic.gdx.Input.Keysmanipulating this way when the players are able to play
    (Used in AnswerButtons listener) **/

    public static void checkAndPlay(){

            if (Gdx.input.isKeyJustPressed(inputActivationState)) {

                ScoreWindow.showScoreWindow(noOfPlayers);
                inputActivationState = inactiveInputState;
                if (noOfPlayers == 2) {

                    ScoreWindow.setActiveScoreWindow(activePlayer);
                    if (activePlayer.equals("player1")) {
                        System.out.println("Player1 Plays");
                        System.out.println("Player1 Score:" + Score.getPlScore1());
                        Dice2.rollAndMove(player1, player1.getTileNum());

                    } else {
                        System.out.println("Player2 Plays");
                        System.out.println("Player 2 Score: " + Score.getPlScore2());
                        Dice2.rollAndMove(player2, player2.getTileNum());
                    }

                } else {
                    activePlayer = "player1";
                    System.out.println("Player1 Plays");
                    System.out.println("Player1 Score :" + Score.getPlScore1());
                    Dice2.rollAndMove(player1, player1.getTileNum());
                }
            }
        }
    }


