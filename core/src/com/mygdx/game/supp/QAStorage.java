package com.mygdx.game.supp;


public class QAStorage {
    private String question ;
    private String[] answers ;
    private String rightAnswer;



    public QAStorage(String question, String[] answers, String rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers(){
        return answers;
    }
    public String getRightAnswer(){
        return rightAnswer;
    }



}
