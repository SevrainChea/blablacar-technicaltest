package com.chea.blablacar.technicaltest.model.lawn;

import com.chea.blablacar.technicaltest.model.mower.Machine;
import lombok.Data;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@Data
public class Lawn {

    private int maxX;
    private int maxY;

    // A list of all the machines with their (x,y) positions
    private ConcurrentLinkedQueue<Machine> machines;

    public Lawn(int maxX, int maxY, List<Machine> machines) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.machines = new ConcurrentLinkedQueue<>(machines);
    }

    public static Lawn build(int maxX, int maxY, List<Machine> machines) {
        return new Lawn(maxX, maxY, machines);
    }

    public boolean isOccupied(int x, int y) {

        if (x > this.maxX || y > this.maxY)
            return true;

        return machines.stream().anyMatch(machine -> machine.getX() == x && machine.getY() == y);
    }

}
