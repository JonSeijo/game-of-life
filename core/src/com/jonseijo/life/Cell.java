package com.jonseijo.life;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cell {

    /*
     No es correcto que este harcodeado.
     La idea seria alrevez, que la textura que cargo dependa del tamaño que seteo.
     Esto hay que arreglarlo, pero para esta etapa no vale invertir tanto tiempo.
    */
    public static final int size = 32;

    private boolean alive;
    private Texture texture;

    public Cell() {
        this(false);
    }

    public Cell(boolean isAlive) {
        this.setAlive(isAlive);
    }

    public void render(SpriteBatch batch, int x, int y) {
        batch.draw(this.texture, x, y);
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        this.texture = alive ? AssetLoader.cell_alive : AssetLoader.cell_dead;
    }


}
