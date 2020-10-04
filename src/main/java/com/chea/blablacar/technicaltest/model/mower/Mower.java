package com.chea.blablacar.technicaltest.model.mower;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Mower implements Machine {

    private int x;
    private int y;
    private Direction direction;

    private Mower(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public static Mower build(int x, int y, Direction direction) {
        return new Mower(x, y, direction);
    }

    @Override
    public void turn(Move move) {
        this.direction = this.direction.turn(move);
    }

    @Override
    public void moveForward() {
        this.x = computeNextX();
        this.y = computeNextY();
    }

    @Override
    public int computeNextX() {
        switch (this.direction) {
            case E:
                return this.x - 1;
            case W:
                return this.x + 1;
            case N:
            case S:
            default:
                return this.x;
        }
    }

    @Override
    public int computeNextY() {
        switch (this.direction) {
            case N:
                return this.y + 1;
            case S:
                return this.y - 1;
            case E:
            case W:
            default:
                return this.y;
        }
    }

    @Override
    public String getFinalPosition() {
        return this.x + " " + this.y + " " + this.direction;
    }

}
