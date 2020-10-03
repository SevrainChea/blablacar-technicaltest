package com.chea.blablacar.technicaltest.model.lawn;

import lombok.Data;

@Data
public class Lawn {

    private int maxX;
    private int maxY;
    private Cell[][] grid;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.grid = new Cell[this.maxX + 1][this.maxY + 1];
        for(int i=0; i<=maxX; i++) {
            for (int j=0; j<=maxY;j++) {
                this.grid[i][j] = new Cell();
            }
        }
    }

    public boolean isOccupied(int x, int y) {

        if(x > this.maxX || y > this.maxY)
            return true;

        return this.grid[x][y].getOccupied();
    }

    public void setFree(int x, int y) {

        this.grid[x][y].setFree();
    }

    public void setOccupied(int x, int y) {

        this.grid[x][y].setOccupied();
    }

}
