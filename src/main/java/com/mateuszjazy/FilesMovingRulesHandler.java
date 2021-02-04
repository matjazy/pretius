package com.mateuszjazy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FilesMovingRulesHandler {

    SystemHandler systemHandler = new SystemHandler();

    FilesMovingRulesHandler(SystemHandler systemHandler){
        this.systemHandler = systemHandler;
    }

    public boolean testIfShouldBeMovedToTest(String fileName){
        if (fileName.contains(".xml")){
            return false;
        }
        if (fileName.contains(".jar")){
            if (fileName.contains(".jar")){
                if (!testIfIsEven(getTimeCreationMilis(fileName))){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean testIfShouldBeMovedToDev(String fileName){
        if (fileName.contains(".xml")){
            return true;
        }
        if (fileName.contains(".jar")){
            if (testIfIsEven(getTimeCreationMilis(fileName))){
                return true;
            }
        }
        return false;
    }

    private long getTimeCreationMilis(String fileName){
        Path path = Paths.get(System.getProperty("user.dir") + systemHandler.getHomePath() + "/" + fileName);
        BasicFileAttributes basicFileAttributes = null;
        try {
            basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        FileTime fileTime = basicFileAttributes.creationTime();
        return fileTime.toMillis();
    }

    private boolean testIfIsEven(long time){
        return time % 2 == 0;
    }


}
