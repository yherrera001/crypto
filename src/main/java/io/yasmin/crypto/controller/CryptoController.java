package io.yasmin.crypto.controller;

import io.yasmin.crypto.CryptoApplication;
import io.yasmin.crypto.model.CoinDesk;
import io.yasmin.crypto.service.CryptoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CryptoController {

    private static final Logger log = LoggerFactory.getLogger(CryptoApplication.class);

    private CryptoService cryptoService;
    private final RestTemplate restTemplate;

    @Autowired
    public CryptoController(CryptoService cryptoService, RestTemplate restTemplate) {
        this.cryptoService = cryptoService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/coinDesk",produces = {MediaType.APPLICATION_JSON_VALUE})
    public CoinDesk getCoinDesk(){
        return cryptoService.getCoinDeskFromApi(restTemplate);
    }
}
