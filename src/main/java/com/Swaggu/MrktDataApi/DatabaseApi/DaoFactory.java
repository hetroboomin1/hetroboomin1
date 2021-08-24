package com.Swaggu.MrktDataApi.DatabaseApi;

public interface DaoFactory {
    public MrktDao getMrktDao(String ticker);
    public MrktDao setMrktDao(String ticker);
}
