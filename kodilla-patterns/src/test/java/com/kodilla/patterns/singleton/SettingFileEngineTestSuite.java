package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SettingFileEngineTestSuite {

    private static SettingsFileEngine settingsFileEngine;

    @BeforeAll
    public static void openSettingFile() {
        settingsFileEngine = SettingsFileEngine.INSTANCE;
        settingsFileEngine.open("myapp.settings");
    }

    @AfterAll
    public static void closeSettingFile() {
        settingsFileEngine.close();
    }

    @Test
    void testGetFillName() {
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);
        assertEquals("myapp.settings", fileName);
    }

    @Test
    void testLoadSettings() {
        boolean result = settingsFileEngine.loadSettings();
        assertTrue(result);
    }

    @Test
    void testSaveSettings() {
        boolean result = settingsFileEngine.saveSettings();
        assertTrue(result);
    }
 }
