package com.mygdx.game.supp;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.game.views.FinishScreen;
import com.mygdx.game.views.PlayScreen;
import static com.mygdx.game.supp.StatisticCollector1.*;
import static com.mygdx.game.views.PlayScreen.noOfPlayers;

public class StatisticsDisplay {


    public static Window statsWindow1;
    public static Window statsWindow2;


    public static void CreatePlayer1StatsWindow() {
        float Player1Stats = (float) getAnswerRightP1() / getPl1QuestionCounter();
        float Player1StatsAlgebra = (float) getAlgRightP1() / getPl1AlgQuestionsCounter();
        float Player1StatsOOP     = (float) getOopRightP1() / getPl1OopQuestionsCounter() ;
        float Player1StatsPBL     = (float) getPblRightP1() / getPl1PblQuestionsCounter();

        String player1StatsText = "You answered : " + .2f% Player1Stats * 100 + " % Correct" ;
        String player1AlgStatsText = "You answered ALG : " + .2f% Player1StatsAlgebra * 100 + " % Correct" ;
        String player1OOpText = "You answered OOP : " + .2f% Player1StatsOOP * 100 + " % Correct" ;
        String player1PBLText = "You answered PBL : " + .2f% Player1StatsPBL * 100 + " % Correct" ;

        statsWindow1 = new Window("", WindowStyle.frameWindowStyle());
        statsWindow1.setMovable(true);
        statsWindow1.setResizable(false);
        statsWindow1.setKeepWithinStage(true);
        statsWindow1.setVisible(true);
        statsWindow1.toFront();

        Label player1Name = new Label("PLAYER1", FontGenerator.scoreLabel());
        Label player1Score = new Label("Your Score is : " +  Score.getPlScore1() + "", FontGenerator.statsLabel());

        Label pl1RightStats = new Label(player1StatsText, FontGenerator.statsLabel());

        if (player1StatsText.contains("NaN")){      // if statements to prevent displaying NaN when no right answer was given
            pl1RightStats.setText("Your general stats 0%");// i.e. 0/questionCounters = NaN
        }

        Label pl1AlgStats = new Label(player1AlgStatsText, FontGenerator.statsLabel());

        if (player1AlgStatsText.contains("NaN")){
            pl1AlgStats.setText("Your Algebra stats 0%");
        }

        Label pl1OopStats = new Label(player1OOpText, FontGenerator.statsLabel());

        if (player1OOpText.contains("NaN")){
            pl1OopStats.setText("Your OOP stats 0%");
        }

        Label pl1PblStats = new Label(player1PBLText, FontGenerator.statsLabel());

        if (player1PBLText.contains("NaN")){
            pl1PblStats.setText("Your PBL stats 0%");
        }


        statsWindow1.add(player1Name).pad(5);
        player1Name.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(player1Score).pad(5);
        player1Score.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1RightStats).pad(5);
        pl1RightStats.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1AlgStats).pad(5);
        pl1AlgStats.setColor(Color.WHITE);
        statsWindow1.row();

        statsWindow1.add(pl1OopStats).pad(5);
        pl1OopStats.setColor(Color.WHITE);
        statsWindow1.row();


        statsWindow1.add(pl1PblStats).pad(5);
        pl1PblStats.setColor(Color.WHITE);
        statsWindow1.row();
        statsWindow1.pack();

        FinishScreen.finishStage.addActor(statsWindow1);

    }
    public static void CreatePlayer2StatsWindow() {

        float Player2Stats = (float) getAnswerRightP2() / getPl2QuestionCounter();
        float Player2StatsAlgebra = (float) getAlgRightP2() / getPl2AlgQuestionsCounter();
        float Player2StatsOOP     = (float) getOopRightP2() / getPl2OopQuestionsCounter() ;
        float Player2StatsPBL     = (float) getPblRightP2() / getPl2PblQuestionsCounter();

        String player2StatsText = "You answered : " + .2f% Player2Stats * 100 + " % Correct" ;
        String player2AlgStatsText = "You answered ALG : " + .2f% Player2StatsAlgebra * 100 + " % Correct" ;
        String player2OOpText = "You answered OOP : " + .2f% Player2StatsOOP * 100 + " % Correct" ;
        String player2PBLText = "You answered PBL : " + .2f% Player2StatsPBL * 100 + " % Correct" ;

        statsWindow2 = new Window("", WindowStyle.frameWindowStyle());
        statsWindow2.setResizable(false);
        statsWindow2.setMovable(true);
        statsWindow2.setKeepWithinStage(true);
        statsWindow2.setVisible(true);
        statsWindow2.toFront();

        Label player2Name = new Label("PLAYER2", FontGenerator.scoreLabel());

        Label player2Score = new Label("Your Score is : " + Score.getPlScore2()+"", FontGenerator.statsLabel());

        Label pl2RightStats = new Label(player2StatsText, FontGenerator.statsLabel());
        if (player2StatsText.contains("NaN")){
            pl2RightStats.setText("Your general stats 0%");
        }

        Label pl2AlgStats = new Label(player2AlgStatsText, FontGenerator.statsLabel());
        if (player2AlgStatsText.contains("NaN")){
            pl2AlgStats.setText("Your Algebra stats 0%");
        }


        Label pl2OopStats = new Label(player2OOpText, FontGenerator.statsLabel());
        if (player2OOpText.contains("NaN")){
            pl2OopStats.setText("Your OOP stats 0%");
        }


        Label pl2PblStats = new Label(player2PBLText, FontGenerator.statsLabel());
        if (player2PBLText.contains("NaN")){
            pl2PblStats.setText("Your PBL stats 0%");
        }

        statsWindow2.add(player2Name).pad(5);
        player2Name.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(player2Score).pad(5);
        player2Score.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2RightStats).pad(5);
        pl2RightStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2AlgStats).pad(5);
        pl2AlgStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2OopStats).pad(5);
        pl2OopStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.add(pl2PblStats).pad(5);
        pl2PblStats.setColor(Color.BLUE);
        statsWindow2.row();

        statsWindow2.pack();

        FinishScreen.finishStage.addActor(statsWindow2);

    }
    public static void showStatsWindow(int noOfPlayers) {

        switch (noOfPlayers){
            case 1:
                CreatePlayer1StatsWindow();
                StatisticsDisplay.statsWindow1.setPosition(490, 150);
                break;
            case 2 :
                CreatePlayer1StatsWindow();
                StatisticsDisplay.statsWindow1.setPosition(0, 150);
                CreatePlayer2StatsWindow();
                StatisticsDisplay.statsWindow2.setPosition(1000, 150);
                break;
        }

    }

public static void removeStatsWindow(int noOfPlayers){

    switch (noOfPlayers){
        case 1:
        StatisticsDisplay.statsWindow1.clear();// this to not draw 3 stats windows after auto switch to endScreen
        StatisticsDisplay.statsWindow1.remove();//
            break;

    case 2:
        StatisticsDisplay.statsWindow1.clear();
        StatisticsDisplay.statsWindow1.remove();
        StatisticsDisplay.statsWindow2.clear();
        StatisticsDisplay.statsWindow2.remove();
        break;
    }
}

}