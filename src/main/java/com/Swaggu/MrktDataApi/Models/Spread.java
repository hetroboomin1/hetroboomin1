package com.Swaggu.MrktDataApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;


//Instead of wrapping the List should I map the list to values when creating the spread?
//make a builder class!! to create and populate model fields...
@JsonIgnoreProperties(ignoreUnknown = true)
public class Spread {

    // private Logger logger = LoggerFactory.getLogger(Spread.class);

    private BigDecimal ask;
    private BigDecimal timestamp;
    private BigDecimal bid;
    private BigDecimal askVol;
    private BigDecimal bidVol;


    public Spread(){
    }

    public Spread(List<BigDecimal> data){
        this.bid = data.get(0);
        this.ask = data.get(1);
        this.timestamp = data.get(2);
        this.bidVol = data.get(3);
        this.askVol = data.get(4);
    }


    public BigDecimal getBid(){
        return bid;
    }

    public BigDecimal getAsk(){
        return ask;
    }

    public BigDecimal getTimestamp(){
        return timestamp;
    }

    public BigDecimal getBidVol(){
        return bidVol;
    }

    public BigDecimal getAskVol(){
        return askVol;
    }
}