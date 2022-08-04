package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle() {
        Shape circle = new Circle();

        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        assertEquals("This is a circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        Shape triangle = new Triangle();

        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        assertEquals("This is a triangle", result);
    }
}