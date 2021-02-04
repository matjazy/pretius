package com.mateuszjazy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilesMovingRulesHandlerTest {

    FilesMovingRulesHandler filesMovingRulesHandler = new FilesMovingRulesHandler(new SystemHandler());

    @Test
    public void testIfShouldBeMovedToDev(){
        assertTrue(filesMovingRulesHandler.testIfShouldBeMovedToDev("file.xml"));
    }

    @Test
    public void testIfShouldBeMovedToTest(){
        assertFalse(filesMovingRulesHandler.testIfShouldBeMovedToTest("file.xml"));
    }
}
