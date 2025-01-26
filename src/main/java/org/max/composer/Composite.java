package org.max.composer;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Shape {
    private final List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        if (component != null) {
            components.add(component);
        }
    }

    public void removeComponent(Shape component) {
        components.remove(component);
    }

    public int getSize() {
        return components.size();
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }
}
