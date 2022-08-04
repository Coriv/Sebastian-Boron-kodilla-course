package com.kodilla.testing.shape;

import com.kodilla.testing.shape.ShapeCollector;
import org.junit.jupiter.api.*;

@DisplayName("Test Suite of class ShapeCollector")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Tests are preparing");
    }

    @AfterAll
    static void afterALl(){
        System.out.println("All tests are finished");
    }

    @BeforeEach
    void beforeEveryTest(){
        testCounter++;
        System.out.println("Test #" + testCounter + " is beginning.");
    }

    @Nested
    @DisplayName("Test of Shapes")
    public class ShapeTests {

        @Test
        public void addFigureTest(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape squar = new Square("squareOne", 2);
            shapeCollector.addFigure(squar);

            Assertions.assertEquals(1, shapeCollector.shapeQuantity());
        }

        @Test
        public void emptyListRemoveFigureTest(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square("Square", 5);

            boolean result = shapeCollector.removeFigure(square);
            Assertions.assertFalse(result);
        }

        @Test
        public void removeFigureTest(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle("circleOne", 2);
            shapeCollector.addFigure(circle);

            boolean result = shapeCollector.removeFigure(circle);

            Assertions.assertTrue(result);
        }

        @Test
        public void getFigureTest(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle("triagnleOne", 3, 4);
            shapeCollector.addFigure(triangle);

            Shape retrievedShape = shapeCollector.getFigure(0);

            Assertions.assertEquals(triangle, retrievedShape);
        }

        @Test
        public void showFiguresTest(){
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square("SquareTwo", 3);
            Shape circle = new Circle("CircleTwo", 6);

            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);

            String result = shapeCollector.showFigures();
            String expected = square.getShapeName() + ", " + circle.getShapeName() + ", ";

            Assertions.assertEquals(expected, result);

        }
    }
}
