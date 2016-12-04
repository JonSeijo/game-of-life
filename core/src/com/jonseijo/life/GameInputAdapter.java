package com.jonseijo.life;

import com.badlogic.gdx.InputAdapter;

public class GameInputAdapter extends InputAdapter{

    private GameLife game;

    public GameInputAdapter(GameLife game) {
        this.game = game;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        return true;
    }



}
