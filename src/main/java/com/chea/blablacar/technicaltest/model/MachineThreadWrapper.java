package com.chea.blablacar.technicaltest.model;

import com.chea.blablacar.technicaltest.model.lawn.Lawn;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import com.chea.blablacar.technicaltest.model.mower.Move;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Wraps a machine into a thread. Also contains a reference to the lawn aware of all other machines' (x,y) positions.
 * The List of moves is executed by the thread.
 */
@Slf4j
@Data
public class MachineThreadWrapper extends Thread {

    private final Lawn lawn;
    private Machine machine;
    private List<Move> moves;

    private MachineThreadWrapper(Lawn lawn, Machine machine, List<Move> moves) {
        this.lawn = lawn;
        this.machine = machine;
        this.moves = moves;
    }

    public static MachineThreadWrapper build(Lawn lawn, Machine machine, List<Move> moves) {
        return new MachineThreadWrapper(lawn, machine, moves);
    }

    @Override
    public void run() {

        log.info("Starting mower " + this.getName());
        log.info(this.moves.toString());

        for (Move move : this.moves) {
            switch (move) {
                case L:
                case R:
                    this.machine.turn(move);
                case F:
                    this.moveForwardMachine();
            }
        }
    }

    private void moveForwardMachine() {
        //synchronized (this.lawn) {
        int tempX = this.machine.computeNextX();
        int tempY = this.machine.computeNextY();

        if (this.lawn.isOccupied(tempX, tempY)) {
            log.info("Cannot move to position " + tempX + " " + tempY);
            return;
        }

        this.machine.moveForward();
        //}
    }

    private String getFinalPosition() {
        return this.machine.getFinalPosition();
    }


}
