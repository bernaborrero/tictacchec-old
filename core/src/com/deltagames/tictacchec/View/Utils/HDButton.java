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

    private float endPositionX;
    private float endPositionY;

    public HDButton(BitmapFont font, String text, float positionX, float positionY) {
        this.font = font;
        this.text = text;

        this.positionX = positionX;
        this.positionY = positionY;

        this.endPositionX = this.positionX + font.getBounds(text).width;
        this.endPositionY = this.endPositionY + font.getBounds(text).height;
    }

    public HDButton(BitmapFont font, String text, boolean centerX, float positionY) {
        this(font, text, 0, positionY);
        this.positionX = getHorizontalCenter();
        this.endPositionX = this.positionX + font.getBounds(text).width;
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

    public boolean isClicked(int screenX, int screenY) {
        return (screenX >= this.positionX && screenX <= this.endPositionX) &&
                (screenY >= this.positionY && screenY <= this.endPositionY);
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

    public float getEndPositionX() {
        return endPositionX;
    }

    public void setEndPositionX(float endPositionX) {
        this.endPositionX = endPositionX;
    }

    public float getEndPositionY() {
        return endPositionY;
    }

    public void setEndPositionY(float endPositionY) {
        this.endPositionY = endPositionY;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
