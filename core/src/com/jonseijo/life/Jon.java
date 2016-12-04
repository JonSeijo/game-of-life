package com.jonseijo.life;

import android.app.ActionBar;

public class Jon {

    private Tablero temporal;

    public Jon(int tam) {
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

    }
}
