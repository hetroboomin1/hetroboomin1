package com.Swaggu.MrktDataApi.Service;

import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Models.ModelFactory;
import com.Swaggu.MrktDataApi.Models.KrakenResponses.OHLC;
import com.Swaggu.MrktDataApi.Models.KrakenResponses.Spread;
import com.fasterxml.jackson.databind.JsonNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KrakenDataService implements MrktDataService{

private final Logger logger = LoggerFactory.getLogger(KrakenDataService.class);

@Autowired
private MrktDao database;
@Autowired
private ModelFactory factory;

    @Override
    public Spread getSpread(String pair) {
        return null;
    }

    @Override
    public OHLC getOHLC(String pair) {
        return null;
    }

    @Override
    public KrakenModels getData(String pair, String channel) {
        KrakenModels dataModel;
        try {
            dataModel = factory.getModel(channel);
        } catch (Exception e) {
            logger.info("Model "+channel+" does not exist");
            e.printStackTrace();
            return null;
        }
        JsonNode retrievedData = database.retrieveData(pair, channel);
        dataModel.setData(retrievedData);
        return dataModel;
    }
}
