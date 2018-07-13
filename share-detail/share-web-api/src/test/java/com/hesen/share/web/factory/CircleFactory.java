package com.hesen.share.web.factory;

import com.hesen.share.web.impl.Circle;
import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class CircleFactory implements ShapeFactoryMethod{
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
