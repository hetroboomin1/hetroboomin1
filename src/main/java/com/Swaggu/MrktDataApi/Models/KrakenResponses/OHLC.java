package com.Swaggu.MrktDataApi.Models.KrakenResponses;

import java.math.BigDecimal;

import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Models.ModelFactory;
import com.fasterxml.jackson.databind.JsonNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OHLC implements KrakenModels {
    private final Logger logger = LoggerFactory.getLogger(OHLC.class);

    private BigDecimal time;
    private BigDecimal eTime;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal VWAP;
    private BigDecimal volume;
    private int count;

    public OHLC() {
        registerModel();
        // ModelFactory.registerModel("ohlc-1", this);
    }

    public void setData(JsonNode ohlcData) {
        this.time = new BigDecimal(ohlcData.get(0).textValue());
        this.eTime = new BigDecimal(ohlcData.get(1).textValue());
        this.open = new BigDecimal(ohlcData.get(2).textValue());
        this.high = new BigDecimal(ohlcData.get(3).textValue());
        this.low = new BigDecimal(ohlcData.get(4).textValue());
        this.close = new BigDecimal(ohlcData.get(5).textValue());
        this.VWAP = new BigDecimal(ohlcData.get(6).textValue());
        this.volume = new BigDecimal(ohlcData.get(7).textValue());
        this.count = Integer.parseInt(ohlcData.get(8).asText());
        // logger.info("int is "+Integer.parseInt(ohlcData.get(8).asText()));
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

    @Override
    public void registerModel() {
        logger.info("Adding ohlc model");
        ModelFactory.registerModel("ohlc-1", this);
    }
}
