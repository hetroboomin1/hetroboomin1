package com.Swaggu.MrktDataApi.DatabaseApi;

import com.fasterxml.jackson.databind.JsonNode;

public interface MrktDao {
    public JsonNode retrieveData(String pair, String channelname);
    // public Spread getLatestSpread(String pair, String channelname);
    // public OHLC getLatestOHLC(String pair, String channelname);
    //public Ticker getTicker();
    //public Trades getTrades();
    //public void setChannel();
}
