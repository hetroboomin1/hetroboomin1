package com.Swaggu.MrktDataApi.Models;

import java.math.BigDecimal;
import java.util.List;

public class OHLC {
    
    private BigDecimal time;
    private BigDecimal eTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal VWAP;
    private BigDecimal volume;
    private int count;

    public OHLC(List<BigDecimal> ohlcData) {
        this.time = ohlcData.get(0);
        this.eTime = ohlcData.get(1);
        this.open = ohlcData.get(2);
        this.high = ohlcData.get(3);
        this.low = ohlcData.get(4);
        this.close = ohlcData.get(5);
        this.VWAP = ohlcData.get(6);
        this.volume = ohlcData.get(7);
        this.count = ohlcData.get(8).intValue();
    }

    public BigDecimal getTime() {
        return time;
    }

    public BigDecimal getETime() {
        return eTime;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getVWAP() {
        return VWAP;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public int getCount() {
        return count;
    }
}
