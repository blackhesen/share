package com.hesen.share.web.impl;

import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle::draw() method.");
    }
}
