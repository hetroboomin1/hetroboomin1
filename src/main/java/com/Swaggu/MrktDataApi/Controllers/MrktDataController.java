package com.Swaggu.MrktDataApi.Controllers;

import com.Swaggu.MrktDataApi.Models.OHLC;
import com.Swaggu.MrktDataApi.Models.Spread;
import com.Swaggu.MrktDataApi.DatabaseApi.DaoFactory;
import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class MrktDataController {
    // private Logger logger = LoggerFactory.getLogger(MrktDataController.class);
    // private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private DaoFactory daoFactory;
    
    private MrktDao mrktDao;

    @GetMapping("/spread")
    public Spread getSpread(@RequestParam(value = "pair") String ticker) {
        mrktDao = daoFactory.getMrktDao(ticker);
        return mrktDao.getLatestSpread();
    }

    @GetMapping("/ohlc")
    public OHLC getOHLC(@RequestParam(value = "pair") String ticker) {
        mrktDao = daoFactory.getMrktDao(ticker);
        return mrktDao.getLatestOHLC();
    }
}
