package com.mygdx.game.supp;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;




public class AnswerButtons {
    public static Sound correct=Gdx.audio.newSound(Gdx.files.internal("core/assets/assetsGame/audio/correct.mp3"));
    public static Sound wrong=Gdx.audio.newSound(Gdx.files.internal("core/assets/assetsGame/audio/wrong.mp3"));

    public static void createButton(final String text, final String rightAnswer) {

        final Button button = new TextButton(text,
                (TextButton.TextButtonStyle) TextButtonStyle.myButtonStyle());// better question/ans text display
        button.setTransform(false);
        button.scaleBy(.2f, .2f);
        button.row();
        button.pack();
        QuestionPopup.getWindow().add(button);
        QuestionPopup.getWindow().row();


// click listener to limit the tap count to only 1 click to avoid incrementing the score more then once per click
        button.addListener(new ClickListener(){
            @Override
            public void setTapCountInterval(float tapCountInterval) {
                if (text.equals(rightAnswer) || !text.equals(rightAnswer))
                tapCountInterval = 1 ;
                setTapCount(1);
                super.setTapCountInterval(tapCountInterval);
            }
        });

// click listener to control right or wrong answers
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                if (text.equals(rightAnswer) ) {
                    setTapCountInterval(1);// setting tap count interval to only one click

                    if (PlayerSwitch.activePlayer.equals( "player1") && getTapCount() == 1 ){
                        correct.play();
                        Score.increasePlScore1(5);

                        StatisticCollector1.setAnswerRightP1(1);
                        StatisticCollector1.setPl1QuestionCounter(1);

                        StatisticCollector1.setAlgRightP1(1, true);// setters with boolean check
                        StatisticCollector1.setOopRightP1(1, true);// for each course
                        StatisticCollector1.setPblRightP1(1, true);
                        StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl1OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl1PblQuestionsCounter(1,true);

                        ScoreWindow.updateScoreTable1();

                    }

                    if (PlayerSwitch.activePlayer.equals( "player2") && getTapCount() == 1 ){
                        correct.play();

                        Score.increasePlScore2(5);
                        StatisticCollector1.setAnswerRightP2(1);
                        StatisticCollector1.setPl2QuestionCounter(1);

                        StatisticCollector1.setAlgRightP2(1, true);
                        StatisticCollector1.setOopRightP2(1, true);
                        StatisticCollector1.setPblRightP2(1, true);

                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);

                        ScoreWindow.updateScoreTable2();

                    }
                    button.addAction(parallel(fadeIn(.2f), color(Color.GREEN)));
                    QuestionPopup.hideQuestionWindow();


                } else {



                    if (PlayerSwitch.activePlayer.equals("player1") && getTapCount() == 1 ) {
                        wrong.play();

                        StatisticCollector1.setPl1QuestionCounter(1);
                        StatisticCollector1.setPl1AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl1OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl1PblQuestionsCounter(1,true);


                        PlayerSwitch.activePlayer="player2";


                    } else {
                        wrong.play();

                        PlayerSwitch.activePlayer="player1";
                        StatisticCollector1.setPl2QuestionCounter(1);
                        StatisticCollector1.setPl2AlgQuestionsCounter(1,true);
                        StatisticCollector1.setPl2OopQuestionsCounter(1,true);
                        StatisticCollector1.setPl2PblQuestionsCounter(1,true);

                    }


                    button.addAction(parallel(fadeIn(.2f), color(Color.RED)));
                    QuestionPopup.hideQuestionWindow();

                }

                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        PlayerSwitch.inputActivationState = PlayerSwitch.activeInputState;
                        System.out.println("\nSPACE IS ENABLED AGAIN");
                    }
                }, .3f);
            }
        });
    }


}