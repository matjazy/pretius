package com.mateuszjazy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SystemHandler {

    private static final String ROOT_PATH = System.getProperty("user.dir");
    private static final String HOME_PATH = "/HOME";
    private static final String DEV_PATH = "/DEV";
    private static final String TEST_PATH = "/TEST";
    private static final String COUNT_FILE_PATH = HOME_PATH + "/count.txt";

    public void generateDirectoriesIfNotExists(){
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

    public void generateCountFileIfNotExists(){
        if (Files.notExists(Paths.get(ROOT_PATH + HOME_PATH + "/count.txt"))) {
            try {
                Files.createFile(Paths.get(ROOT_PATH + HOME_PATH + "/count.txt"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public String getCountFilePath(){
        return COUNT_FILE_PATH;
    }


    private void generateHomeIfNotExists() throws IOException {
        if (Files.notExists(Paths.get(ROOT_PATH + HOME_PATH))) {
            Files.createDirectory(Paths.get(ROOT_PATH + HOME_PATH));
        }
    }

    private void generateDevIfNotExists() throws IOException{
        if (Files.notExists(Paths.get(ROOT_PATH + DEV_PATH))) {
            Files.createDirectory(Paths.get(ROOT_PATH + DEV_PATH));
        }
    }

    private void generateTestIfNotExists() throws IOException{
        if (Files.notExists(Paths.get(ROOT_PATH + TEST_PATH))) {
            Files.createDirectory(Paths.get(ROOT_PATH + TEST_PATH));
        }
    }
}
