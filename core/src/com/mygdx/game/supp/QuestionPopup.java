package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.mygdx.game.views.PlayScreen;
import static com.badlogic.gdx.math.MathUtils.random;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class QuestionPopup {


    public static Window window;
    public static Image transparentImg;
    public static Texture texture;

    public static Window getWindow() {
        return window;
    }

    private static Label questionDisplay(String name) {

        Label label = new Label(name,FontGenerator.textLabelStyle() );  // displays the questions much better then using a skin
        label.setWrap(true);
        label.setFontScale(1.3f);
        label.pack();
        return label;
    }

    // Setting once inside the stage the transparent background
    private static void transparentBackground() {

        texture = new Texture(Gdx.files.internal("core/assets/assetsGame/transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setName("Transparency");
        transparentImg.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(transparentImg);
    }

    // Used in the show() method of the PlayScreen class to create
    // and setup our question window and transparency inside the stage
    private static String windowTitle = "Quiz" ;



    public static void createQuestionWindow() {

        // Set a darker transparent background
        transparentBackground();


        window = new Window("", WindowStyle.boardWindowStyle());// better window display ...
        window.setName("Question Window");

        // Start by hiding the window (setting the alpha value zero)

        window.setColor(1, 1, 1, 0);
        window.setResizable(true);
        window.setMovable(false);
        window.setKeepWithinStage(true);
        window.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        window.row();
        window.pack();

        PlayScreen.playStage.addActor(window);

    }

    // Updating the elements of the window
    private static void updateQuestionWindow(final int randNr) {

        if (CourseProperties.checkForPbl()) {

            QAStorage pbl = new QAStorage(PBLQuestions.pblQues[randNr], PBLQuestions.pblAns[randNr], PBLQuestions.pblAns[randNr][PBLQuestions.pblRightAns[randNr]]);


            window.add(questionDisplay(pbl.getQuestion())).prefWidth(600).pad(20);
            window.row();

            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][0],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][1],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][2],pbl.getRightAnswer());
            AnswerButtons.createButton(PBLQuestions.pblAns[randNr][3],pbl.getRightAnswer());

        }


        if (CourseProperties.checkForOop()) {
            QAStorage oop = new QAStorage(OOPQuestions.oopQues[randNr], OOPQuestions.oopAns[randNr], OOPQuestions.oopAns[randNr][OOPQuestions.oopRightAns[randNr]]);

            window.add(questionDisplay(oop.getQuestion())).prefWidth(600).pad(20);
            window.row();

            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][0],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][1],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][2],oop.getRightAnswer());
            AnswerButtons.createButton(OOPQuestions.oopAns[randNr][3],oop.getRightAnswer());

        }


        if (CourseProperties.checkForAlgebra()) {
            QAStorage alg = new QAStorage(ALGQuestions.algQues[randNr], ALGQuestions.algAns[randNr], ALGQuestions.algAns[randNr][ALGQuestions.algRightAns[randNr]]);

            window.add(questionDisplay(alg.getQuestion())).prefWidth(600).pad(20);
            window.row();

            AnswerButtons.createButton(ALGQuestions.algAns[randNr][0],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][1],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][2],alg.getRightAnswer());
            AnswerButtons.createButton(ALGQuestions.algAns[randNr][3],alg.getRightAnswer());
        }


        window.row();
        window.pack();
        window.setTransform(true);
        window.setPosition((PlayScreen.mapW - window.getWidth()) / 2f, ((PlayScreen.mapH - window.getHeight()) / 2f) + 4);
        Gdx.input.setInputProcessor(PlayScreen.playStage);
        window.toFront();
        windowTitle = "Player " + PlayerSwitch.activePlayer;
    }

    // Used in runnable action of movePawn() method
    public static void showQuestionWindow() {

        int randNr = random.nextInt(50);
        updateQuestionWindow(randNr);

        if (Dice2.tileNum == 100) {

            transparentImg.setVisible(false);
            window.setVisible(false);
        }
        else {

            transparentImg.addAction(Actions.after(Actions.delay(.1f, Actions.fadeIn(.6f, Interpolation.smooth))));
            window.addAction(Actions.after(Actions.fadeIn(.6f, Interpolation.smooth)));
        }
    }

    // Used in AnswerButtons button listener
    // Hiding the question window and simultaneously cleaning its actors for the next set of question and answers

    public static void hideQuestionWindow() {


        window.addAction(Actions.after(sequence(Actions.fadeOut(.6f, Interpolation.smooth), new RunnableAction(){
            @Override
            public void run() {
                window.addAction(Actions.removeActor(window));// better to remove it from the stage
                window.clear();
            }
        })));

        transparentImg.addAction(sequence(Actions.fadeOut(.6f, Interpolation.smooth),new RunnableAction(){
        @Override
            public void run() {
                transparentImg.addAction(Actions.removeActor(transparentImg));
                transparentImg.clear();
            }
        }
        ));

    }
}
