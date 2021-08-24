package com.Swaggu.MrktDataApi.Exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidTicker extends Exception{

   public InvalidTicker(){
        super("data does not exist yet");
    }
}
