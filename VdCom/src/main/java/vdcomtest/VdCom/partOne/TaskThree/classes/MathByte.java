package vdcomtest.VdCom.partOne.TaskThree.classes;

import vdcomtest.VdCom.partOne.TaskThree.interfaces.MathByteInterfaces;

public class MathByte implements MathByteInterfaces {
    @Override
    public double MathByte(double kB) {

        double kilobyte;
        double bit;
        double byter;

        kilobyte = kB;
        byter = kilobyte * 1024;
        bit = byter * 8;

        return bit;


    }
}
