package com.kodilla;

import com.kodilla.spring.shape.Shape;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaSpringApplicationTests {

	@Test
	void testCircleLoadedIntoContainer() {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("circle");

		String name = shape.getShapeName();

		assertEquals("This is a circle.", name);
	}

	@Test
	void testTriangleLoadedIntoContainer() {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");
		Shape shape = (Shape) context.getBean("triangle");

		String name = shape.getShapeName();

		assertEquals("This is a triangle.", name);
	}

	@Test
	void testSquareLoadedIntoContainer() {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");

		Shape shape = (Shape) context.getBean("createSquare");

		String result = shape.getShapeName();

		assertEquals("This is a square.", result);
	}

	@Test
	void testShapeLoadedIntoContainer() {
		ApplicationContext context =
				new AnnotationConfigApplicationContext("com.kodilla.spring");

		Shape shape = (Shape) context.getBean("chosenShape");

		String result = shape.getShapeName();

		System.out.println(result);
	}

	@Test
	void contextLoads() {
	}

}