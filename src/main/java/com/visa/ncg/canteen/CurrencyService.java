package com.visa.ncg.canteen;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyService {


    int convertToGbp(int amount)
    {
        RestTemplate restTemplate = new RestTemplate();
        String convertedCurrencyUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";
        Map<String, String> params = new HashMap<>();
        params.put("amount", String.valueOf(amount));
        params.put("to", "USD");
        params.put("from", "GBP");
        ConvertedJSON convertedValue = restTemplate.getForObject(convertedCurrencyUrl, ConvertedJSON.class, params);
        return convertedValue.getConverted();
    }
}
