package vdcomtest.VdCom.partOne.TaskThree.classes;

import vdcomtest.VdCom.partOne.TaskThree.interfaces.MathGirInterfaces;

public class MathGir implements MathGirInterfaces {

    @Override
    public double MatchGir(double gir) {
        double hare;
        double cat;
        double giraffe;


        giraffe = gir;
        cat = 5 / (0.5 * giraffe);
        hare = (cat) * 4;

        return hare;
    }
}
