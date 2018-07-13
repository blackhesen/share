package com.hesen.share.web.test;

import com.hesen.share.web.factory.CircleFactory;
import com.hesen.share.web.factory.RectangleFactory;
import com.hesen.share.web.factory.ShapeFactory;
import com.hesen.share.web.factory.SquareFactory;
import org.junit.Test;

/**
 * @author hesen
 */
public class FactoryTest {

    /**
     * 静态工厂模式测试
     */
    @Test
    public void staticFactory() {
        // first method
        ShapeFactory.createShape("circle").draw();
        ShapeFactory.createShape("rectangle").draw();
        ShapeFactory.createShape("square").draw();
        System.out.println("==========================");
        // second method
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("circle").draw();
        shapeFactory.getShape("rectangle").draw();
        shapeFactory.getShape("square").draw();
    }

    /**
     * 工厂方法模式测试：抽象工厂模式只是多族产品，如果是单一族便是工厂方法模式
     */
    @Test
    public void methodFactory() {
        new CircleFactory().getShape().draw();
        new RectangleFactory().getShape().draw();
        new SquareFactory().getShape().draw();
    }

}
