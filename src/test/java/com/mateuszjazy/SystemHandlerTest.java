package com.mateuszjazy;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertTrue;

public class SystemHandlerTest {

    @Test
    public void testDirectoriesGeneration(){
        SystemHandler systemHandler = new SystemHandler();
        systemHandler.generateDirectories();
        assertTrue(Files.exists(Path.of(systemHandler.getHomePath())));
        assertTrue(Files.exists(Path.of(systemHandler.getDevPath())));
        assertTrue(Files.exists(Path.of(systemHandler.getTestPath())));
    }

}
