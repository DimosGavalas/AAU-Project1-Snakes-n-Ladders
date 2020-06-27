package com.mygdx.game.supp;

import com.badlogic.gdx.maps.MapProperties;
import static com.mygdx.game.supp.Dice2.tileNum;
import static com.mygdx.game.supp.Pawn.getTileProperties;

public  class CourseProperties {

    public static boolean checkForPbl(){

        MapProperties tilesProperties = getTileProperties(tileNum);
        boolean containPbl = tilesProperties.containsKey("pbl");
        if (containPbl){
            return  true;}
            return false;
    }
    public static boolean checkForOop(){

        MapProperties tilesProperties = getTileProperties(tileNum);
       boolean containOop = tilesProperties.containsKey("oop");

        if (containOop){
            return  true;}
        return false;
    }
    public static boolean checkForAlgebra(){

        MapProperties tilesProperties = getTileProperties(tileNum);
       boolean containAlgebra = tilesProperties.containsKey("algebra");

        if (containAlgebra){
            return  true;}
        return false;
    }

}
