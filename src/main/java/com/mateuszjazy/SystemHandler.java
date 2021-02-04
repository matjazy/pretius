package com.mateuszjazy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SystemHandler {

    private static final String ROOT = System.getProperty("user.dir");
    private static final String HOME_PATH = "/HOME";
    private static final String DEV_PATH = "/DEV";
    private static final String TEST_PATH = "/TEST";

    public void generateDirectories(){
        try {
            generateHomeIfNotExists();
            generateDevIfNotExists();
            generateTestIfNotExists();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getHomePath(){
        return HOME_PATH;
    }

    public String getDevPath(){
        return DEV_PATH;
    }

    public String getTestPath(){
        return TEST_PATH;
    }

    public void generateCountFile(){

    }

    public String getCountFilePath(){
        return null;
    }


    private void generateHomeIfNotExists() throws IOException {
        if (Files.notExists(Paths.get(ROOT + HOME_PATH))) {
            Files.createDirectory(Paths.get(ROOT + HOME_PATH));
        }
    }

    private void generateDevIfNotExists() throws IOException{
        if (Files.notExists(Paths.get(ROOT + DEV_PATH))) {
            Files.createDirectory(Paths.get(ROOT + DEV_PATH));
        }
    }

    private void generateTestIfNotExists() throws IOException{
        if (Files.notExists(Paths.get(ROOT + TEST_PATH))) {
            Files.createDirectory(Paths.get(ROOT + TEST_PATH));
        }
    }
}
