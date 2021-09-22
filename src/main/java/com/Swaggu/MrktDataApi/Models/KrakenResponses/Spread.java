package com.Swaggu.MrktDataApi.Models.KrakenResponses;

import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Models.ModelFactory;
import com.fasterxml.jackson.databind.JsonNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//Instead of wrapping the List should I map the list to values when creating the spread?
//make a builder class!! to create and populate model fields...
@Component
public class Spread implements KrakenModels {

    private Logger logger = LoggerFactory.getLogger(Spread.class);

    private BigDecimal ask;
    private BigDecimal timestamp;
    private BigDecimal bid;
    private BigDecimal askVol;
    private BigDecimal bidVol;

    public Spread() {
        registerModel();
    }

    public void setData(JsonNode data) {
        this.bid = new BigDecimal(data.get(0).asText());
        this.ask = new BigDecimal(data.get(1).asText());
        this.timestamp = new BigDecimal(data.get(2).asText());
        this.bidVol = new BigDecimal(data.get(3).asText());
        this.askVol = new BigDecimal(data.get(4).asText());
    }

    public BigDecimal getBid() {
        return bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public BigDecimal getTimestamp() {
        return timestamp;
    }

    public BigDecimal getBidVol() {
        return bidVol;
    }

    public BigDecimal getAskVol() {
        return askVol;
    }

    @Override
    public void registerModel() {
        logger.info("Adding spread model");
        ModelFactory.registerModel("spread", this);
    }
}