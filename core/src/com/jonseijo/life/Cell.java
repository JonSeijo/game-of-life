package com.jonseijo.life;

public class Cell {

    boolean alive;

    public Cell() {
        this(false);
    }

    public Cell(boolean isAlive) {
        this.alive = isAlive;
    }

    public boolean isAlive() {
        return this.alive;
    }

}
