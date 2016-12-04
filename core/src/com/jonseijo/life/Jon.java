package com.jonseijo.life;

import android.app.ActionBar;

public class Jon {

    // @JONNO
    // Optimizacion, que this.temporal sea una simple matriz de booleanos, bitmap quiza
    // No hay neccesidad de que contenga Cells
    private Tablero temporal;
    private int tam;

    public Jon(int tam) {
        this.tam = tam;
        this.temporal = new Tablero(tam);
    }

    /*
    Este metodo es el encargado de aplicar las reglas de la vida,
    modificando el tablero para llevarlo a un nuevo estado.

    1) Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    2) Any live cell with two or three live neighbours lives on to the next generation.
    3) Any live cell with more than three live neighbours dies, as if by over-population.
    4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    */
    public void simular(Tablero tablero) {

        for (int i = 0; i < this.tam; i++) {
            for (int j = 0; j < this.tam; j++) {

                // (i, j) es mi celda actual
                int vecinosVivos = tablero.vecinosVivos(i, j);

                // Si esta viva..
                if (tablero.get(i, j)) {
                    if (vecinosVivos == 2 || vecinosVivos == 3) {
                        this.temporal.set(i, j, true);
                    } else {
                        this.temporal.set(i, j, false);
                    }
                }
                // Si esta muerta..
                else {
                    if (vecinosVivos == 3) {
                        this.temporal.set(i, j, true);
                    } else {
                        this.temporal.set(i, j, false);
                    }
                }

            }
        }

        // @JONNO: Quiza deberia tirar una excepcion si este metodo no se llama
        this.copiarEstados(tablero);
    }

    private void copiarEstados(Tablero tablero) {
        for (int i = 0; i < this.tam; i++) {
            for (int j = 0; j < this.tam; j++) {
                tablero.set(i, j, this.temporal.get(i, j));
            }
        }
    }

}
