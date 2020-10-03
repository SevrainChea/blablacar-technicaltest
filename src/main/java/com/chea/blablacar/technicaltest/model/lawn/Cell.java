package com.chea.blablacar.technicaltest.model.lawn;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Cell {

    private Object lock;
    private boolean occupied;

    public Cell() {
        this.lock = new Object();
        this.occupied = false;
    }

    public boolean getOccupied() {
        return this.occupied;
    }

    public void setOccupied() {
        synchronized (lock) {
            this.occupied = true;
        }
    }

    public void setFree() {
        synchronized (lock) {
            this.occupied = false;
        }
    }

}
