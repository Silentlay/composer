package org.max.composer;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();
        Shape square3 = new Square();
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composite firstGroup = new Composite();
        Composite secondGroup = new Composite();
        Composite mainGroup = new Composite();

        firstGroup.addComponent(square1);
        firstGroup.addComponent(square2);
        firstGroup.addComponent(triangle1);

        secondGroup.addComponent(square3);
        secondGroup.addComponent(circle1);
        secondGroup.addComponent(circle2);
        secondGroup.addComponent(circle3);

        mainGroup.addComponent(firstGroup);
        mainGroup.addComponent(secondGroup);

        mainGroup.draw();
    }
}
