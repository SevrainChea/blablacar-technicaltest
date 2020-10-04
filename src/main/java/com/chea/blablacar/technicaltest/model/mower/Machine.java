package com.chea.blablacar.technicaltest.model.mower;

public interface Machine {

    void turn(Move move);

    void moveForward();

    int computeNextX();

    int computeNextY();

    int getX();

    int getY();

    Direction getDirection();

    String getFinalPosition();

}
