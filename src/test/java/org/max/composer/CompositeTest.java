package org.max.composer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;

public class CompositeTest {

    private Composite composite;

    @BeforeEach
    void setUp() {
        composite = new Composite();
    }

    @Test
    void testAddComponent() {
        // given
        Shape circle = new Circle();

        // when
        composite.addComponent(circle);

        // then
        Assertions.assertEquals(1, composite.getSize());
    }

    @Test
    void testRemoveComponent() {
        // given
        Shape square = new Square();
        composite.addComponent(square);

        // when
        composite.removeComponent(square);

        // then
        Assertions.assertEquals(0, composite.getSize());
    }

    @ParameterizedTest
    @ValueSource(classes = {Circle.class, Square.class})
    void testAddMultipleComponents(Class<? extends Shape> shapeClass) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // given
        Shape shape = shapeClass.getDeclaredConstructor().newInstance();

        // when
        composite.addComponent(shape);

        // then
        Assertions.assertEquals(1, composite.getSize());
    }

    @Test
    public void testAddNullComponent() {
        // given
        // when
        composite.addComponent(null);

        // then
        Assertions.assertEquals(0, composite.getSize());
    }

    @Test
    void testRemoveNonExistentComponent() {
        // given
        Shape triangle = new Triangle();
        composite.addComponent(new Square());

        // when
        composite.removeComponent(triangle);

        // then
        Assertions.assertEquals(1, composite.getSize());
    }
}
