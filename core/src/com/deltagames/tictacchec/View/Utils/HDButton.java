package com.deltagames.tictacchec.View.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Class to manage High Definition Buttons
 * Created by Bernabé Borrero on 5/05/15.
 */
public class HDButton {

    private BitmapFont font;
    private String text;
    private float positionX;
    private float positionY;

    public HDButton(BitmapFont font, String text, float positionX, float positionY) {
        this.font = font;
        this.text = text;

        this.positionX = positionX;
        this.positionY = positionY;
    }

    public HDButton(BitmapFont font, String text, boolean centerX, float positionY) {
        this(font, text, 0, positionY);
        this.setPositionX(getHorizontalCenter());
    }

    public HDButton(BitmapFont font, String text) {
        this(font, text, 0, 0);
    }

    public float getHorizontalCenter() {
        return (Gdx.graphics.getWidth() - font.getBounds(text).width) / 2;
    }

    public void draw(SpriteBatch spriteBatch) {
        font.draw(spriteBatch, text, positionX, positionY);
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
