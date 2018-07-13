package com.hesen.share.web.factory;

import com.hesen.share.web.impl.Circle;
import com.hesen.share.web.impl.Rectangle;
import com.hesen.share.web.impl.Square;
import com.hesen.share.web.manager.Shape;

/**
 * 简单工厂模式----静态工厂模式
 * @author hesen
 *
 */
public class ShapeFactory {

    /**
     * 静态方法
     * @param type
     * @return
     */
    public static Shape createShape(String type) {

        // first method--> if...else if...else
        if ("circle".equals(type)) {
            return new Circle();
        } else if ("rectangle".equals(type)) {
            return new Rectangle();
        } else if ("square".equals(type)) {
            return new Square();
        } else {
            return null;
        }

        // second method--> switch...case...
        //switch (type) {
        //    case "circle":
        //        return new Circle();
        //    case "rectangle":
        //        return new Rectangle();
        //    case "square":
        //        return new Square();
        //    default:
        //        return null;
        //}

    }

    public Shape getShape(String type) {
        if ("circle".equals(type)) {
            return new Circle();
        } else if ("rectangle".equals(type)) {
            return new Rectangle();
        } else if ("square".equals(type)) {
            return new Square();
        } else {
            return null;
        }
    }
}
