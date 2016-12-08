package com.jonseijo.life;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class GameGestureAdapter implements GestureDetector.GestureListener{

    private GameLife game;

    public GameGestureAdapter(GameLife game) {
        this.game = game;
    }

    @Override
    public boolean touchDown (float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        if (distance > initialDistance) {
            game.zoomOut();
        } else {
            game.zoomIn();
        }
        return true;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        game.siguienteGeneracion();
        return true;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        game.pan(x, y, deltaX, deltaY);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {

        return false;
    }
    @Override
    public boolean pinch (Vector2 initialFirstPointer, Vector2 initialSecondPointer, Vector2 firstPointer, Vector2 secondPointer){

        return false;
    }

    @Override
    public void pinchStop () {
    }
}
