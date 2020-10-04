package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.model.mower.Direction;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TechnicalTest {

    @Test
    public void testSingleMower1() {

        ContextHolder context = TestFileRunner.runTest("SingleMower1.txt");
        Machine machine = context.getMachineThreadWrappers().get(0).getMachine();

        assertEquals(1, machine.getX());
        assertEquals(3, machine.getY());
        assertEquals(Direction.N, machine.getDirection());

    }

    @Test
    public void testSingleMower2() {

        ContextHolder context = TestFileRunner.runTest("SingleMower2.txt");
        Machine machine = context.getMachineThreadWrappers().get(0).getMachine();

        assertEquals(1, machine.getX());
        assertEquals(1, machine.getY());
        assertEquals(Direction.E, machine.getDirection());
    }

    @Test
    public void testMultipleMowers() {

        ContextHolder context = TestFileRunner.runTest("MultipleMowers1.txt");

        Machine machine1 = context.getMachineThreadWrappers().get(0).getMachine();
        Machine machine2 = context.getMachineThreadWrappers().get(1).getMachine();

        assertEquals(1, machine1.getX());
        assertEquals(3, machine1.getY());
        assertEquals(Direction.N, machine1.getDirection());

        assertEquals(5, machine2.getX());
        assertEquals(1, machine2.getY());
        assertEquals(Direction.E, machine2.getDirection());

    }


}
