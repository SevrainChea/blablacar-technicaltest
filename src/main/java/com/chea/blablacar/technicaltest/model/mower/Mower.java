package com.chea.blablacar.technicaltest.model.mower;

import com.chea.blablacar.technicaltest.model.lawn.Lawn;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class Mower implements Machine {

    private int x;
    private int y;
    private Direction direction;
    private List<Move> moves;

    private Lawn lawn;

    public Mower(int x, int y, Direction direction, String moves, Lawn lawn) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.moves = parseMovesString(moves);
        this.lawn = lawn;
    }

    private List<Move> parseMovesString(String stringMoves) {
        List<Move> moves = new ArrayList<>();

        for (String s : stringMoves.toUpperCase().split("")) {
            try {
                moves.add(Enum.valueOf(Move.class, s));
            } catch (IllegalArgumentException e) {
                log.error("Error parsing move " + s);
            }
        }

        return moves;
    }

    private void turn(Move move, String name) {
        Direction newDirection = this.direction.turn(move);
        log.info("Turning " + name + " from " + this.direction + " to " + newDirection);
        this.direction = this.direction.turn(move);

    }

    private void moveForward(String name) {

        int tempX = computeNextXPosition(this.direction);
        int tempY = computeNextYPosition(this.direction);

        if (this.lawn.isOccupied(tempX, tempY)) {
            log.info(name + " cannot move to position " + tempX + " " + tempY);
            return;
        }

        log.info("Moving " + name + " from " + this.getCurrentPosition() + " to " + tempX + " " + tempY);
        this.lawn.setFree(this.x, this.y);
        this.lawn.setOccupied(tempX, tempY);

        this.x = tempX;
        this.y = tempY;
    }

    private int computeNextXPosition(Direction direction) {
        switch (direction) {
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

    private int computeNextYPosition(Direction direction) {
        switch (direction) {
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

    private String getCurrentPosition() {
        return this.x + " " + this.y;
    }

    private String getFinalPosition() {
        return this.getCurrentPosition() + " " + this.direction;
    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void moveForward() {

    }

    @Override
    public void computeNextX() {

    }

    @Override
    public void computeNextY() {

    }
}
