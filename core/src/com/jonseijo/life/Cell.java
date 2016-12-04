package com.jonseijo.life;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cell {

    private boolean alive;
    private Texture texture;

    public Cell() {
        this(false);
    }

    public Cell(boolean isAlive) {
        this.setAlive(isAlive);
    }

    public void render(SpriteBatch batch) {
        // Todavia no hace nada, tengo que ver quien y como controla la posicion
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        this.texture = alive ? AssetLoader.cell_alive : AssetLoader.cell_dead;
    }

}
