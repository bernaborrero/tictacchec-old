package com.deltagames.tictacchec.View.Utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Class to manage High Definition fonts
 * Created by Bernabé Borrero on 5/05/15.
 */
public abstract class HDFont extends BitmapFont {

    public static final FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

    public static BitmapFont getFont(FreeTypeFontGenerator fontGenerator, int size, Color color) {
        fontParameter.size = size;
        fontParameter.color = color;

        return fontGenerator.generateFont(fontParameter);
    }

}
