package io.kyleaure.knitting.util;

/**
 * A converter between cm and inches
 */
public final class Measure {
    private static final double CM_PER_IN = 2.54;

    public static enum Unit {
        CENTIMETER, INCH
    }
    private double cm; //store everything in cm and convert to inches when necessary

    private Measure() {
        // Builder class, do not allow use of constructor
    }

    public static Measure of(double length, Unit unit) {
        Measure inst = new Measure();
        switch(unit) {
            case Unit.CENTIMETER:
                inst.cm = length;
                break;
            case Unit.INCH:
                inst.cm = length * CM_PER_IN;
                break;
        }

        return inst;
    }

    public double to(Unit unit) {
        switch(unit) {
            case Unit.CENTIMETER:
                return this.cm;
            case Unit.INCH:
                return this.cm / CM_PER_IN;
            default:
                throw new RuntimeException("Unsupported enum");
        }
    }

}
