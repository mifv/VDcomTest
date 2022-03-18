package vdcomtest.VdCom.partOne.TaskThree.classes;

import vdcomtest.VdCom.partOne.TaskThree.interfaces.MathPirInterfaces;

public class MathPir implements MathPirInterfaces {
    @Override
    public double MathPir(double pir) {

            double piramid;
            double bar;
            double ring;

            piramid = pir;
            ring = 16.8 / (piramid * 2);
            bar = (ring * 2) / 12;

            return bar;
    }
}
