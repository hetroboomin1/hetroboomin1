package com.Swaggu.MrktDataApi.Models.Exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidTicker extends Exception{

   public InvalidTicker(){
        super("data does not exist yet, from advice");
    }
}
