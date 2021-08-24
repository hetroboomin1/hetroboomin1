package com.Swaggu.MrktDataApi.DatabaseApi;

import com.Swaggu.MrktDataApi.Models.OHLC;
import com.Swaggu.MrktDataApi.Models.Spread;

public interface MrktDao {
    public Spread getLatestSpread();
    public OHLC getLatestOHLC();
    //public Ticker getTicker();
    //public Trades getTrades();
    //public 
}
