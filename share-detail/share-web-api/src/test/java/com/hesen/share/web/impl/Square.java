package com.hesen.share.web.impl;

import com.hesen.share.web.manager.Shape;

/**
 * @author hesen
 */
public class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square::draw() method.");
    }
}
