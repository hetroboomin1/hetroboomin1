package com.Swaggu.MrktDataApi.Models;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

//Abstractfactory to create models and return them based on the given channelname...
@Component
public class ModelFactory {

    private static Map<String, KrakenModels> map = new HashMap<String, KrakenModels>();

    public ModelFactory() {
    }

    // Adds the model class
    public static void registerModel(String channel, KrakenModels model) {
        map.put(channel, model);
    }

    public KrakenModels getModel(String channel) throws Exception {
        if (map.get(channel)==null){
            throw new Exception();
        }
        return map.get(channel);
    }
}
