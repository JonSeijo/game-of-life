package com.jonseijo.life;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Tablero {

    private int tam;
    private ArrayList<ArrayList<Boolean>> tablero;

    public Tablero() {
        this(25);
    }

    public Tablero(int tam) {
        this.tam = tam;

        // Creo un tablero cuadrado lleno de Falses
        this.tablero = new ArrayList<ArrayList<Boolean>>(this.tam);
        for (int i = 0; i < this.tam; i++) {
            ArrayList<Boolean> arrayInterno = new ArrayList<Boolean>(this.tam);
            for (int j = 0; j < this.tam; j++) {
                arrayInterno.add(Boolean.FALSE);
            }
            this.tablero.add(arrayInterno);
        }
    }

    public void render(SpriteBatch batch) {

    }

    public void set(int x, int y, boolean value) {
        this.tablero.get(x).set(y, Boolean.valueOf(value));
    }

    public boolean get(int x, int y) {
        return this.tablero.get(x).get(y);
    }

    public void dispose() {

    }

}
