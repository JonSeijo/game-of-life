package com.jonseijo.life;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {

    public static Texture cell_alive;
    public static Texture cell_dead;

    public AssetLoader() {
        this.cell_alive = new Texture(Gdx.files.internal("cell_blue.png"));
        this.cell_dead = new Texture(Gdx.files.internal("cell_black.png"));
    }

    public void dispose() {
        this.cell_alive.dispose();
        this.cell_dead.dispose();
    }

}
