package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.exceptions.MalformedInputException;
import com.chea.blablacar.technicaltest.model.MachineThreadWrapper;
import com.chea.blablacar.technicaltest.model.lawn.Lawn;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import com.chea.blablacar.technicaltest.model.mower.Move;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Builds the context from the String inputs
 * - Lawn's size
 * - Machines' initial positions and direction
 * - A List of moves
 */
public class ContextHolderBuilder {

    public static ContextHolder buildFromInput(List<String> lines) {

        if (CollectionUtils.isEmpty(lines))
            throw new MalformedInputException();

        List<MachineThreadWrapper> machineThreadWrappers = new ArrayList<>();
        List<Machine> machines = new ArrayList<>();

        String[] size = InputParser.parseSize(lines.get(0));
        int maxX = Integer.parseInt(size[0]);
        int maxY = Integer.parseInt(size[1]);
        Lawn lawn = Lawn.build(maxX, maxY, machines);

        for (int i = 1; i < lines.size(); i++) {

            Machine machine = InputParser.parseMachine(lines.get(i));
            List<Move> moves = InputParser.parseMoves(lines.get(++i));

            machines.add(machine);
            machineThreadWrappers.add(MachineThreadWrapper.build(lawn, machine, moves));

        }


        return ContextHolder.build(machineThreadWrappers);

    }

}
