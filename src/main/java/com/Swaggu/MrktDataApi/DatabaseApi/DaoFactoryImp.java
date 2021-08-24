package com.Swaggu.MrktDataApi.DatabaseApi;

import java.util.HashMap;
import java.util.Map;

import com.Swaggu.MrktDataApi.Config.DaoFactoryConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class DaoFactoryImp implements DaoFactory {
    private Logger logger = LoggerFactory.getLogger(DaoFactoryImp.class);

    private Map<String, MrktDao> listDaos = new HashMap<>();

    //Singleton factory?
    @Autowired
    public DaoFactoryImp(DaoFactoryConfig daoFactoryConfig){
        this.listDaos = daoFactoryConfig.getDaos();
    }

    @Override
    public MrktDao getMrktDao(String ticker) {
        if(listDaos.get(ticker) == null){
            logger.info("404 ticker not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ticker does not exist");
        }
        return listDaos.get(ticker);
    }

    @Override
    public MrktDao setMrktDao(String ticker) {
        // TODO Auto-generated method stub
        return null;
    }
}
