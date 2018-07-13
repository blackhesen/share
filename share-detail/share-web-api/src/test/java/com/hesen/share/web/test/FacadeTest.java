package com.hesen.share.web.test;

import com.hesen.share.web.facade.Computer;
import org.junit.Test;

/**
 * @author hesen
 */
public class FacadeTest {

    @Test
    public void methodFactory() {
        Computer computer = new Computer();
        computer.start();
        System.out.println("=====================");
        computer.shutDown();
    }
}
