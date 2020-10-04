package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.model.mower.Direction;
import com.chea.blablacar.technicaltest.model.mower.Machine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TechnicalTest {

    @Test
    public void testSingleMower1() throws InterruptedException, URISyntaxException, IOException {

        URL systemResource = ClassLoader.getSystemResource("SingleMower1.txt");
        List<String> inputs = Files.lines(Paths.get(systemResource.toURI())).collect(Collectors.toList());
        ContextHolder context = ContextHolderBuilder.buildFromInput(inputs);
        context.start();
        Machine machine = context.getMachineThreadWrappers().get(0).getMachine();
        assertEquals(1, machine.getX());
        assertEquals(3, machine.getY());
        assertEquals(Direction.N, machine.getDirection());

    }

    @Test
    public void testSingleMower2() throws InterruptedException, URISyntaxException, IOException {

        URL systemResource = ClassLoader.getSystemResource("SingleMower2.txt");
        List<String> inputs = Files.lines(Paths.get(systemResource.toURI())).collect(Collectors.toList());
        ContextHolder context = ContextHolderBuilder.buildFromInput(inputs);
        context.start();
        Machine machine = context.getMachineThreadWrappers().get(0).getMachine();

        assertEquals(1, machine.getX());
        assertEquals(1, machine.getY());
        assertEquals(Direction.E, machine.getDirection());
    }

    @Test
    public void test() throws InterruptedException, URISyntaxException, IOException {

        URL systemResource = ClassLoader.getSystemResource("MultipleMowers1.txt");
        List<String> inputs = Files.lines(Paths.get(systemResource.toURI())).collect(Collectors.toList());
        ContextHolder context = ContextHolderBuilder.buildFromInput(inputs);
        context.start();
        Machine machine = context.getMachineThreadWrappers().get(0).getMachine();

    }


}
