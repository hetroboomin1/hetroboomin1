package com.Swaggu.MrktDataApi.Models;

import java.math.BigDecimal;
import java.util.List;

public class OHLC {
    
    private List<BigDecimal> ohlcData;

    public OHLC(List<BigDecimal> ohlcData) {
        this.ohlcData = ohlcData;
    }

    public void setOHLCData(List<BigDecimal> ohlcData) {
        this.ohlcData = ohlcData;
    }

    public BigDecimal getTime() {
        return ohlcData.get(0);
    }

    public BigDecimal getETime() {
        return ohlcData.get(1);
    }

    public BigDecimal getOpen() {
        return ohlcData.get(2);
    }

    public BigDecimal getHigh() {
        return ohlcData.get(3);
    }

    public BigDecimal getLow() {
        return ohlcData.get(4);
    }

    public BigDecimal getClose() {
        return ohlcData.get(5);
    }

    public BigDecimal getVWAP() {
        return ohlcData.get(6);
    }

    public BigDecimal getVolume() {
        return ohlcData.get(7);
    }

    public BigDecimal getCount() {
        return ohlcData.get(8);
    }
}
