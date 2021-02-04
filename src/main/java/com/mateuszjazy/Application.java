package com.mateuszjazy;

public class Application {

    public static void main (String[] args){
        SystemHandler systemHandler = new SystemHandler();
        systemHandler.generateDirectoriesIfNotExists();
        systemHandler.generateCountFileIfNotExists();
    }
}
