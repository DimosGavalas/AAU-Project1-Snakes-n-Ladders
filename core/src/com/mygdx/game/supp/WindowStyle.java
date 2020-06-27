package com.mygdx.game.supp;
/**
 *
 * **/
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class WindowStyle {

    public  static Texture backgroundTexture = new Texture(Gdx.files.internal("core/assets/assetsGame/frame1.png"));
    public static  Texture backgroundTexture1 ;

// constructor to create my own windowStyle  and return it for further use

    public static Window.WindowStyle boardWindowStyle() {

        Drawable tableBackground = new TextureRegionDrawable(new TextureRegion(backgroundTexture));
        BitmapFont myFont=FontGenerator.fontForText();// calling for my own font
        Window.WindowStyle myWindStyle1 = new Window.WindowStyle(myFont, Color.BLACK, tableBackground);
        return myWindStyle1;
    }


// customizing the frame of the window for better layout and display
    public static Window.WindowStyle frameWindowStyle() {

        backgroundTexture1 = new Texture(Gdx.files.internal("core/assets/assetsGame/paper.png"));
        BitmapFont myFont1 = FontGenerator.fontForText();     // calling for my own font
        Drawable Background = new TextureRegionDrawable(new TextureRegion(backgroundTexture1));
        Window.WindowStyle myWindStyle2 = new Window.WindowStyle(myFont1, Color.BLACK, Background);

        return myWindStyle2;
    }
}

