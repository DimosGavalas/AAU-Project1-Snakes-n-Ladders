package com.mygdx.game.supp;

import static com.mygdx.game.views.PlayScreen.*;

public class ScoreDisplay {


    public static void scorePanel(){

        if (noOfPlayers == 1) {
            player1 = new Pawn("Player1");
            Pawn.addToPawnList(player1);
            player1.setInStage(1000);
            ScoreWindow.createScoreWindow1();
        }
        if (noOfPlayers == 2)
        {
            player1 = new Pawn("Player1");
            player1.setInStage(1000);
            Pawn.addToPawnList(player1);
            ScoreWindow.createScoreWindow1();

            player2 = new Pawn( "Player2");
            player2.setInStage(2000);
            Pawn.addToPawnList(player2);
            ScoreWindow.createScoreWindow2();
        }

    }
}
