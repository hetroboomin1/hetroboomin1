package com.Swaggu.MrktDataApi.DatabaseApi.KrakenDatabase.Factory;

import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;

public interface DaoFactory {
    public MrktDao getMrktDao(String ticker);
    public MrktDao setMrktDao(String ticker);
}
