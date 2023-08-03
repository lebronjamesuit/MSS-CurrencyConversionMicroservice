package com.jamesclear.first.microservice.CurrencyConversionMicroservice.Controller;

import com.jamesclear.first.microservice.model.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CurrencyConversionFluxController {

    private final String endpoint = "http://localhost:8000/currency-exchange/all";
    private final Logger logger = LoggerFactory.getLogger(CurrencyConversionFluxController.class);

    @GetMapping(value = "/flux/currency-conversion/all")
    public ResponseEntity<List<CurrencyConversionBean>> getAllCurrenciesExchange() {
		int quantity = 10;
        Flux<CurrencyExchange>  currencyExchangeFlux = getFluxAllCurrencyExchange();
        Mono<List<CurrencyExchange>> monoListExchange = currencyExchangeFlux.collectList();
		List<CurrencyExchange> exchanges = monoListExchange.block(Duration.ofSeconds(2));
        List<CurrencyConversionBean> beanList = exchanges.stream().map(e -> {
            CurrencyConversionBean conversionBean = new CurrencyConversionBean();
            conversionBean.setTotalCalculatedAmount(e.getConversionMultiple() * Double.valueOf(quantity));
            conversionBean.setQuantity(Integer.valueOf(quantity));
            conversionBean.setEnvironment(e.getEnvironment() + "  Spring Flux");
            return conversionBean;
		}).collect(Collectors.toList());
        return  new ResponseEntity<>(beanList, HttpStatusCode.valueOf(200))  ;
    }

    public  Flux<CurrencyExchange> getFluxAllCurrencyExchange() {
        logger.info("Starting NON-BLOCKING Controller!");
        Flux<CurrencyExchange> currencyExchangeFlux = WebClient
                .create()
                .get()
                .uri(endpoint)
                .retrieve()
                .bodyToFlux(CurrencyExchange.class);

      /*  currencyExchangeFlux.subscribe( ex -> {
            logger.info("inside subscribe, this will run after the method is finished ");
        });*/
        logger.info("End NON-BLOCKING Controller!");
        return  currencyExchangeFlux  ;
    }


}

