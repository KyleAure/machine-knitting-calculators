package io.kyleaure.knitting.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.kyleaure.knitting.util.Measure.Unit;

public class MeasureTest {
    @Test
    public void testZero() {
        Measure m1 = Measure.of(0, Unit.CENTIMETER);

        // Assert conversions
        assertEquals(0.0, m1.to(Unit.CENTIMETER));
        assertEquals(0.0, m1.to(Unit.INCH));

        Measure m2 = Measure.of(0, Unit.INCH);

        // Assert conversions
        assertEquals(0.0, m2.to(Unit.CENTIMETER));
        assertEquals(0.0, m2.to(Unit.INCH));
    }

    @Test
    public void testSingle() {
        Measure m1 = Measure.of(1, Unit.CENTIMETER);

        // Assert conversions
        assertEquals(1.0, m1.to(Unit.CENTIMETER));
        assertEquals(0.3937008, m1.to(Unit.INCH));

        Measure m2 = Measure.of(1, Unit.INCH);

        // Assert conversions
        assertEquals(2.54, m2.to(Unit.CENTIMETER));
        assertEquals(1.0, m2.to(Unit.INCH));
    }

    @Test
    public void testArithmatic() {
        //using decimal representation
        Measure m1 = Measure.of(2.54, Unit.CENTIMETER);
        assertEquals(2.54, m1.to(Unit.CENTIMETER));
        assertEquals(1.0, m1.to(Unit.INCH));

        //using factional representation
        Measure m2 = Measure.of(1, 3, Unit.INCH);
        
        assertEquals(0.8466667, m2.to(Unit.CENTIMETER));
        assertEquals(0.3333333, m2.to(Unit.INCH));
    }
}
