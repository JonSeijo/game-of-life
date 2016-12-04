package com.jonseijo.life;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Tablero {

    private int tam;
    private ArrayList<ArrayList<Cell>> tablero;

    public Tablero() {
        this(25);
    }

    public Tablero(int tam) {
        this.tam = tam;

        // Creo un tablero cuadrado lleno de Falses
        this.tablero = new ArrayList<ArrayList<Cell>>(this.tam);
        for (int i = 0; i < this.tam; i++) {
            ArrayList<Cell> arrayInterno = new ArrayList<Cell>(this.tam);
            for (int j = 0; j < this.tam; j++) {
                arrayInterno.add(new Cell(false));
            }
            this.tablero.add(arrayInterno);
        }
    }

    public void render(SpriteBatch batch) {

    }

    public void set(int x, int y, boolean value) {
        this.tablero.get(x).get(y).setAlive(value);
    }

    public boolean get(int x, int y) {
        return this.tablero.get(x).get(y).isAlive();
    }

    public void dispose() {

    }

}
