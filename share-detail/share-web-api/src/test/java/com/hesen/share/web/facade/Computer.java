package com.hesen.share.web.facade;

import com.hesen.share.web.children.CPU;
import com.hesen.share.web.children.Disk;
import com.hesen.share.web.children.Memory;

/**
 * 外观模式
 * @author hesen
 */
public class Computer {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        cpu = new CPU();
        disk = new Disk();
        memory = new Memory();
    }

    public void start() {
        System.out.println("Computer start begin...");
        cpu.start();
        disk.start();
        memory.start();
        System.out.println("Computer start end...");
    }

    public void shutDown() {
         System.out.println("Computer shutDown begin...");
         cpu.shutDown();
         disk.shutDown();
         memory.shutDown();
         System.out.println("Computer shutDown end...");
    }

}
