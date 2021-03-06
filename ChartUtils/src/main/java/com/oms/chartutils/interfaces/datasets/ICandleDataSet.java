package com.oms.chartutils.interfaces.datasets;

import android.graphics.Paint;

import com.oms.chartutils.data.CandleEntry;


public interface ICandleDataSet extends ILineScatterCandleRadarDataSet<CandleEntry> {


    float getBarSpace();


    boolean getShowCandleBar();


    float getShadowWidth();


    int getShadowColor();


    int getNeutralColor();


    int getIncreasingColor();


    int getDecreasingColor();


    Paint.Style getIncreasingPaintStyle();


    Paint.Style getDecreasingPaintStyle();


    boolean getShadowColorSameAsCandle();
}
