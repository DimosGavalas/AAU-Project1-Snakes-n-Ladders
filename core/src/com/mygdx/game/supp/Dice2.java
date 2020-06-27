package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.views.PlayScreen;
import java.util.Random;

public class Dice2 {
   public static int tileNum;
    private static int targetTileNum;
    private static Random random = new Random();
    public static int dice;

    private TileBoard3 parent;
    private static Sound diceSound;

    // Creating an instance of the Class Pawn so to be able to use it's methods in a static context
    public static Pawn playingPawn;

    public static void rollAndMove(Pawn pawn, int newTileNum) {
        diceSound = Gdx.audio.newSound(Gdx.files.internal("core/assets/assetsGame/audio/dice.mp3"));
            diceSound.play();

            tileNum = newTileNum;
            playingPawn = pawn;

            dice = random.nextInt(6) + 1;
            DiceDisplay.updateDiceImage(dice);
            tileNum += dice;
            if (tileNum <= 100) {
                // If contains special <<>>  Movement to special tile
                
                if (playingPawn.checkTileForSpecial(tileNum)) {
                    targetTileNum = playingPawn.getTargetTileNum(Pawn.getTileProperties(tileNum));
//                  targetTileNum = tileNum; // uncomment to remove special tile for better testing
                    playingPawn.movePawn(tileNum, targetTileNum, dice);

                    // Setting the new tile number and save it for the current player
                    tileNum = targetTileNum;
                    playingPawn.setTileNum(tileNum);

                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;

                } else { // Normal movement from tile to tile
                    playingPawn.movePawn(tileNum, targetTileNum, dice);
                    playingPawn.setTileNum(tileNum);
                }

                // Setting when game will finish
                if (playingPawn.getTileNum() == 100) {

                    // Runnable action added so the pawn moves first to the
                    // 100th tile and after that the EndScreens shows up
                    playingPawn.pawn.addAction(Actions.after(Actions.delay(.7f, new RunnableAction(){
                        @Override
                        public void run() {
                            PlayScreen.parent.changeScreen(TileBoard3.FINISHGAME, Interpolation.smooth);
                            QuestionPopup.getWindow().remove();
                            Pawn.resetPawn();
                            ScoreWindow.resetScoreTables();
                            PlayerSwitch.inputActivationState = PlayerSwitch.activeInputState;
                            System.gc();

                        }
                    })));

                }

            } else {
                tileNum -= dice;
                playingPawn.pawn.clearActions();
                // QuestionPopup.showQuestionWindow() method, has been inserted as runnable action with a small delay
                // This delay fixes the occasion where its nested method updateQuestionWindow(randNr) don't have the
                // time to get and set the question and its answers inside the window
                playingPawn.pawn.addAction(Actions.delay(.3f, new RunnableAction(){
                    @Override
                    public void run() {

                        QuestionPopup.showQuestionWindow();

                    }
                }));
            }

            System.out.println(dice + "  " + tileNum);
    }
}
