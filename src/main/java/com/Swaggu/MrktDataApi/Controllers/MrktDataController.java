package com.Swaggu.MrktDataApi.Controllers;

import com.Swaggu.MrktDataApi.Models.Spread;
import com.Swaggu.MrktDataApi.DatabaseApi.DaoFactory;
import com.Swaggu.MrktDataApi.DatabaseApi.MrktDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/greeting")
public class MrktDataController {
    private Logger logger = LoggerFactory.getLogger(MrktDataController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private DaoFactory daoFactory;

    // private MrktDao dao;
    // Latest spread data
    @GetMapping("/greeting")
    public Spread getSpread(@RequestParam(value = "pair") String ticker) { // Returns a spread object but needs to be
                                                                           // converted to JSON, Spring handles this
                                                                           // already

        MrktDao mrktDao;
        mrktDao = daoFactory.getMrktDao(ticker);
        return mrktDao.getLatestSpread();
    }
}
