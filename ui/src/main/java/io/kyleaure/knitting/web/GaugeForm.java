package io.kyleaure.knitting.web;

import io.kyleaure.knitting.util.Measure;

/* 
 * This interface represents the gauge of a knit fabirc.
 * Gauge - the ratio of stitches*rows to a square of fabric
 */ 
public class GaugeForm {
    private int stitches;
    private int rows;
    private Measure size;
}