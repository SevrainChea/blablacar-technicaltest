package com.chea.blablacar.technicaltest;

import com.chea.blablacar.technicaltest.exceptions.TestFileRunnerException;
import lombok.Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TestFileRunner {

    private TestFileRunner() {
    }

    public static ContextHolder runTest(String resourceFileName) {
        try {
            URL systemResource = ClassLoader.getSystemResource(resourceFileName);
            List<String> inputs = Files.lines(Paths.get(systemResource.toURI())).collect(Collectors.toList());
            ContextHolder context = ContextHolderBuilder.buildFromInput(inputs);
            context.start();
            return context;
        } catch (InterruptedException | IOException | URISyntaxException e) {
            e.printStackTrace();
            throw new TestFileRunnerException("Unexpected error occurred", e);
        }
    }
}
