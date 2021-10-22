package com.Swaggu.MrktDataApi.Models.KrakenResponses;

import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Models.ModelFactory;
import com.fasterxml.jackson.databind.JsonNode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//Instead of wrapping the List should I map the list to values when creating the spread?
//make a builder class!! to create and populate model fields...
@Component
public class Ticker implements KrakenModels {

    private Logger logger = LoggerFactory.getLogger(Ticker.class);

    // @JsonProperty("a")
    // private List<Object> ask;
    // @JsonProperty("b")
    // private List<Object> bid;
    // @JsonProperty("c")
    // private List<BigDecimal> close;
    // @JsonProperty("v")
    // private List<BigDecimal> volume;
    // @JsonProperty("p")
    // private List<BigDecimal> pvolume;
    // @JsonProperty("t")
    // private List<Integer> trades;
    // @JsonProperty("l")
    // private List<BigDecimal> lowprice;
    // @JsonProperty("h")
    // private List<BigDecimal> highprice;
    // @JsonProperty("o")
    // private List<BigDecimal> openprice;

    private JsonNode ask;
    private JsonNode bid;
    private JsonNode close;
    private JsonNode volume;
    private JsonNode pvolume;
    private JsonNode trades;
    private JsonNode lowprice;
    private JsonNode highprice;
    private JsonNode openprice;
    // private ArrayNode 

    public Ticker() {
        registerModel();
    }

    public JsonNode getOpenprice() {
        return openprice;
    }

    public void setOpenprice(JsonNode openprice) {
        this.openprice = openprice;
    }

    public JsonNode getHighprice() {
        return highprice;
    }

    public void setHighprice(JsonNode highprice) {
        this.highprice = highprice;
    }

    public JsonNode getLowprice() {
        return lowprice;
    }

    public void setLowprice(JsonNode lowprice) {
        this.lowprice = lowprice;
    }

    public JsonNode getTrades() {
        return trades;
    }

    public void setTrades(JsonNode trades) {
        this.trades = trades;
    }

    public JsonNode getPvolume() {
        return pvolume;
    }

    public void setPvolume(JsonNode pvolume) {
        this.pvolume = pvolume;
    }

    public JsonNode getVolume() {
        return volume;
    }

    public void setVolume(JsonNode volume) {
        this.volume = volume;
    }

    public JsonNode getClose() {
        return close;
    }

    public void setClose(JsonNode close) {
        this.close = close;
    }

    public JsonNode getBid() {
        return bid;
    }

    public void setBid(JsonNode bid) {
        this.bid = bid;
    }

    public JsonNode getAsk() {
        return ask;
    }

    public void setAsk(JsonNode ask) {
        this.ask = ask;
    }

    public void setData(JsonNode data) {
        logger.info("Setting ticker data");
        this.setAsk(data.get("a"));
        this.setBid(data.get("b"));
        this.setClose(data.get("c"));
        this.setVolume(data.get("v"));
        this.setPvolume(data.get("p"));
        this.setTrades(data.get("t"));
        this.setLowprice(data.get("l"));
        this.setHighprice(data.get("h"));
        this.setOpenprice(data.get("o"));
    }

    @Override
    public void registerModel() {
        logger.info("Adding ticker model");
        ModelFactory.registerModel("ticker", this);
    }
}
