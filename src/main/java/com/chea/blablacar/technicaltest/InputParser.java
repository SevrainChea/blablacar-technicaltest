package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.exceptions.MalformedInputException;
import com.chea.blablacar.technicaltest.model.mower.Direction;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import com.chea.blablacar.technicaltest.model.mower.Move;
import com.chea.blablacar.technicaltest.model.mower.Mower;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    public static String[] parseSize(String line) {
        return line.split(" ");
    }

    public static Machine parseMachine(String line) {

        String[] inputLine = line.split(" ");

        try {
            return Mower.build(Integer.parseInt(inputLine[0]), Integer.parseInt(inputLine[1]),
                    Enum.valueOf(Direction.class, inputLine[2]));

        } catch (IllegalArgumentException e) {
            throw new MalformedInputException("Error parsing mower", e);
        }
    }

    public static List<Move> parseMoves(String line) {

        try {
            return Stream.of(line.split(""))
                    .map(m -> Enum.valueOf(Move.class, m))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new MalformedInputException("Error parsing moves", e);
        }

    }
}
