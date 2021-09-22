package com.Swaggu.MrktDataApi.Controllers;

import com.Swaggu.MrktDataApi.Models.KrakenModels;
import com.Swaggu.MrktDataApi.Service.MrktDataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/market")
public class MrktDataController {
    private Logger logger = LoggerFactory.getLogger(MrktDataController.class);

    @Autowired
    private MrktDataService service;

    @GetMapping("/spread")
    public Mono<KrakenModels> getSpread(@RequestParam(value = "pair") String pair) { // Automatically converts to json
        logger.info("Spread request");
        return getData(pair, "spread");
    }

    @GetMapping("/ohlc")
    public Mono<KrakenModels> getOHLC(@RequestParam(value = "pair") String pair) {
        logger.info("OHLC request");
        return getData(pair, "ohlc-1");
    }

    @GetMapping("/ticker")
    public Mono<KrakenModels> getTicker(@RequestParam(value = "pair") String pair) {
        // mrktDao = daoFactory.getMrktDao(pair);
        logger.info("Ticker request");
        return getData(pair, "ticker");
    }

    private Mono<KrakenModels> getData(String pair, String channelname) {
        Mono<KrakenModels> model = Mono.just(service.getData(pair, channelname));
        return model;
    }
}
