package com.hesen.share.web.impl;

import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle::draw() method.");
    }
}
