package io.kyleaure.knitting.util;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * A converter between cm and inches
 */
public final class Measure {
    // Ratio of centimeters to inches
    private static final BigDecimal CM_PER_IN = new BigDecimal(2.54);

    public static enum Unit {
        CENTIMETER, INCH
    }

    // Store everything in cm and convert to inches when necessary
    private BigDecimal cm; 

    private Measure() {
        // Builder class, do not allow use of constructor
    }

    // Measure is a whole number: example 1 cm / 1 in
    public static Measure of(int value, Unit unit) {
        return of(BigDecimal.valueOf(value), unit);
    }

    // Measure is a decimal: example 2.45 cm / 0.5 in
    public static Measure of(double value, Unit unit) {
        return of(BigDecimal.valueOf(value), unit);
    }

    // Measure is a fraction
    public static Measure of(int numerator, int denominator, Unit unit) {
        return of(BigDecimal.valueOf((double) numerator / denominator), unit);
    }

    private static Measure of(BigDecimal value, Unit unit) {
        Measure inst = new Measure();
        switch(unit) {
            case Unit.CENTIMETER:
                inst.cm = value;
                break;
            case Unit.INCH:
                inst.cm = value.multiply(CM_PER_IN, MathContext.DECIMAL32);
                break;
        }
        return inst;
    }

    public double to(Unit unit) {
        switch(unit) {
            case Unit.CENTIMETER:
                return cm.doubleValue();
            case Unit.INCH:
                return cm.divide(CM_PER_IN, MathContext.DECIMAL32).doubleValue();
            default:
                throw new RuntimeException("Unsupported enum");
        }
    }

}
