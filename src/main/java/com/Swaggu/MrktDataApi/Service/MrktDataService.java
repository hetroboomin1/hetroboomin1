package com.Swaggu.MrktDataApi.Service;

import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Models.KrakenResponses.OHLC;
import com.Swaggu.MrktDataApi.Models.KrakenResponses.Spread;

public interface MrktDataService {
    public Spread getSpread(String pair);
    public OHLC getOHLC(String pair);
    public KrakenModels getData(String pair, String channel);
}
