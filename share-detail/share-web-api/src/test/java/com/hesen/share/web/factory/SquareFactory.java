package com.hesen.share.web.factory;

import com.hesen.share.web.impl.Square;
import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class SquareFactory implements ShapeFactoryMethod{
    @Override
    public Shape getShape() {
        return new Square();
    }

}
