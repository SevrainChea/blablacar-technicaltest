package com.chea.blablacar.technicaltest.model;

import com.chea.blablacar.technicaltest.model.lawn.Lawn;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import com.chea.blablacar.technicaltest.model.mower.Move;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class MowerThread extends Thread {

    private Lawn lawn;
    private Machine machine;
    private List<Move> moves;

    private MowerThread(Lawn lawn, Machine machine, List<Move> moves) {
        this.lawn = lawn;
        this.machine = machine;
        this.moves = moves;
    }

    public static MowerThread build(Lawn lawn, Machine machine, List<Move> moves) {
        return new MowerThread(lawn, machine, moves);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        log.info("Starting mower " + name);
        log.info(moves.toString());

        for (Move move : moves) {
            switch (move) {
                case L:
                case R:
                    //machine.turn(move, name);
                case F: {
                    //machine.moveForward(name);
                }
            }
        }
    }
}
