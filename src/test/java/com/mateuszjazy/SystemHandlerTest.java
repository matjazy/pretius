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
        assertTrue(Files.exists(Path.of(System.getProperty("user.dir")+systemHandler.getHomePath())));
        assertTrue(Files.exists(Path.of(System.getProperty("user.dir")+Path.of(systemHandler.getDevPath()))));
        assertTrue(Files.exists(Path.of(System.getProperty("user.dir")+Path.of(systemHandler.getTestPath()))));
    }

    @Test
    public void testGenerateCountFile(){
        SystemHandler systemHandler = new SystemHandler();
        systemHandler.generateCountFile();
        assertTrue(Files.exists(Path.of(System.getProperty("user.dir")+Path.of(systemHandler.getCountFilePath()))));
    }

}
