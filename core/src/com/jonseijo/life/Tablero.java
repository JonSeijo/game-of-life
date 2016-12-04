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

    private int getN(int x, int y) {
        if (x < 0 || x >= this.tam || y < 0 || y >= this.tam) {
            return 0;
        }
        return (this.get(x, y)) ? 1 : 0;
    }

    // @JONNO
    // Estoy repitiendo codigo en vecinosmuertos y vecinosvivos

    public int vecinosVivos(int x, int y) {
        // @JONNO deberia tirar una excepcion
        if (x < 0 || x >= this.tam || y < 0 || y >= this.tam) {
            return 0;
        }

        // Reviso los 8 vecinos, (excluyo al cual le pregunto)
        int vivos = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x && j != y) {
                    vivos += this.getN(i, j);
                }
            }
        }
        return vivos;
    }

    public int vecinosMuertos(int x, int y) {
        // @JONNO deberia tirar una excepcion
        if (x < 0 || x >= this.tam || y < 0 || y >= this.tam) {
            return 0;
        }

        // Reviso los 8 vecinos, (excluyo al cual le pregunto)
        int muertos = 8;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x && j != y) {
                    muertos -= this.getN(i, j);
                }
            }
        }
        return muertos;
    }


    public void dispose() {

    }

}
