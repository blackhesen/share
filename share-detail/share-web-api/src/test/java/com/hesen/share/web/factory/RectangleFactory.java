package com.hesen.share.web.factory;

import com.hesen.share.web.impl.Rectangle;
import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class RectangleFactory implements ShapeFactoryMethod{
    @Override
    public Shape getShape() {
        return new Rectangle();
    }

}
