package com.mygdx.game.supp;

/**class for setting and getting questions and answers and using them in AnswerButton class
 * to increment right answers in general or for each course
 * **/
public class StatisticCollector1 {


//---------------------------------------- player1  questions counter--------------------------------------
    static int pl1QuestionCounter ;

    public static void setPl1QuestionCounter(int pl1QuestionCounter) {
    StatisticCollector1.pl1QuestionCounter += pl1QuestionCounter;
    }

    public static int getPl1QuestionCounter() {
        return pl1QuestionCounter;
    }
//---------------------------------------- player1  general right answers counter--------------------------------------

    static int answerRightP1 ;

    public static void setAnswerRightP1(int answerRightP1) {
            StatisticCollector1.answerRightP1 += answerRightP1;
    }

    public static int getAnswerRightP1() {
        return answerRightP1;
    }

//------------------ counter for how many questions for each course ------------------------------------
//---------------------------------------- player1  --------------------------------------------------------
//---------------------------------------- ALG  --------------------------------------------------------

    static int pl1AlgQuestionsCounter ;
    public static void setPl1AlgQuestionsCounter(int pl1AlgQuestionsCounter, boolean checkForAlgebra ) {

         if (checkForAlgebra == CourseProperties.checkForAlgebra())
            StatisticCollector1.pl1AlgQuestionsCounter += pl1AlgQuestionsCounter;
    }

    public static int getPl1AlgQuestionsCounter() {
        return pl1AlgQuestionsCounter ;
    }
//---------------------------------------- OOP  --------------------------------------------------------

    static int pl1OopQuestionsCounter ;
    public static void setPl1OopQuestionsCounter(int pl1OopQuestionsCounter, boolean checkForOop) {

        if (checkForOop == CourseProperties.checkForOop())
            StatisticCollector1.pl1OopQuestionsCounter += pl1OopQuestionsCounter;
    }

    public static int getPl1OopQuestionsCounter() {
        return pl1OopQuestionsCounter ;
    }
//---------------------------------------- PBL  --------------------------------------------------------

    static int pl1PblQuestionsCounter ;

    public static void setPl1PblQuestionsCounter(int pl1PblQuestionsCounter, boolean checkForPbl) {

        if (checkForPbl == CourseProperties.checkForPbl())
            StatisticCollector1.pl1PblQuestionsCounter += pl1PblQuestionsCounter;
    }

    public static int getPl1PblQuestionsCounter() {
        return pl1PblQuestionsCounter ;
    }
//---------------------------- counters for each rightAnswer for each course -------------------------------------
//---------------------------------------- ALG  --------------------------------------------------------


    static int AlgRightP1;
    public static void setAlgRightP1(int algRightP1, boolean checkForAlgebra) {

        if (checkForAlgebra == CourseProperties.checkForAlgebra())
            AlgRightP1 += algRightP1;
    }

    public static int getAlgRightP1() {
        return AlgRightP1;
    }

//---------------------------------------- OOP  --------------------------------------------------------

    static int oopRightP1;
    public static void setOopRightP1(int oopRightP1, boolean checkForOop) {

        if (checkForOop == CourseProperties.checkForOop())
            StatisticCollector1.oopRightP1 = +oopRightP1;
    }


    public static int getOopRightP1() {
        return oopRightP1;
    }

//---------------------------------------- PBL  --------------------------------------------------------
   static int pblRightP1;
    public static void setPblRightP1(int pblRightP1, boolean checkForPbl) {

        if (checkForPbl == CourseProperties.checkForPbl())
            StatisticCollector1.pblRightP1 += pblRightP1;
    }

    public static int getPblRightP1() {
        return pblRightP1;
    }
//|----------------------------------------------------------------------------------------------------------------|
//|---------------------------------------- PLAYER2  --------------------------------------------------------------|


    //---------------------------------------- counters for each rightAnswer for player2

    static int answerRightP2 ;

    public static void setAnswerRightP2(int answerRightP2) {

        StatisticCollector1.answerRightP2 += answerRightP2;
    }
    public static int getAnswerRightP2() {
        return answerRightP2;
    }


//---------------------------------------- counter of questions for player2----------------------------------------

    static int pl2QuestionCounter ;

    public static void setPl2QuestionCounter(int pl2QuestionCounter) {
        StatisticCollector1.pl2QuestionCounter += pl2QuestionCounter;
    }

    public static int getPl2QuestionCounter() {
        return pl2QuestionCounter;
    }

//---------------------------------------- counter of Answers for each  course ----------------------------------------
   private static int pl2AlgQuestionsCounter ;
   private static int pl2OopQuestionsCounter ;
   private static int pl2PblQuestionsCounter ;


    public static void setPl2AlgQuestionsCounter(int pl2AlgQuestionsCounter,boolean checkForAlgebra) {

        if (checkForAlgebra == CourseProperties.checkForAlgebra())
            StatisticCollector1.pl2AlgQuestionsCounter += pl2AlgQuestionsCounter;
    }
    public static int getPl2AlgQuestionsCounter() {
        return pl2AlgQuestionsCounter;
    }

    public static void setPl2OopQuestionsCounter(int pl2OopQuestionsCounter, boolean checkForOop) {

        if (checkForOop == CourseProperties.checkForOop())
            StatisticCollector1.pl2OopQuestionsCounter += pl2OopQuestionsCounter;
    }

    public static int getPl2OopQuestionsCounter() {
        return pl2OopQuestionsCounter;
    }


    public static void setPl2PblQuestionsCounter(int pl2PblQuestionsCounter, boolean checkForPbl) {

        if (checkForPbl == CourseProperties.checkForPbl())
            StatisticCollector1.pl2PblQuestionsCounter += pl2PblQuestionsCounter;

    }

    public static int getPl2PblQuestionsCounter() {
            return pl2PblQuestionsCounter;
    }
    static int AlgRightP2;

    static int oopRightP2;

    static int pblRightP2;



    public static void setAlgRightP2(int algRightP2 , boolean checkForAlgebra) {

        if (checkForAlgebra == CourseProperties.checkForAlgebra())
            AlgRightP2 += algRightP2;
    }

    public static int getAlgRightP2() {
        return AlgRightP2;
    }

    public static void setOopRightP2(int oopRightP2 , boolean checkForOop) {

        if (checkForOop == CourseProperties.checkForOop())
            StatisticCollector1.oopRightP2 += oopRightP2;
    }

    public static int getOopRightP2() {
        return oopRightP2;
    }

    public static void setPblRightP2(int pblRightP2, boolean checkForPbl) {

        if (checkForPbl == CourseProperties.checkForPbl())
            StatisticCollector1.pblRightP2 += pblRightP2;
    }


    public static int getPblRightP2() {
        return pblRightP2;
    }



}
