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

        // Creo un tablero cuadrado lleno de celulas muertas
        this.tablero = new ArrayList<ArrayList<Cell>>(this.tam);
        for (int i = 0; i < this.tam; i++) {
            ArrayList<Cell> arrayInterno = new ArrayList<Cell>(this.tam);
            for (int j = 0; j < this.tam; j++) {
                arrayInterno.add(new Cell(false));
            }
            this.tablero.add(arrayInterno);
        }
    }

    /*
        @JONNO
        Esto esta harcodeando pixeles, no esta muy bueno hacer eso.
        Arreglar para que use tamaños custom, por ejemplo, celulas por pantalla o algo asi
     */
    public void render(SpriteBatch batch) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < this.tam; i++) {
            x = i*Cell.size;
            for (int j = 0; j < this.tam; j++) {
                y = j*Cell.size;
                this.tablero.get(i).get(j).render(batch, x, y);
            }
        }
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
