package io.yasmin.crypto.service;

import io.yasmin.crypto.CryptoApplication;
import io.yasmin.crypto.model.CoinDesk;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoServiceImpl implements CryptoService {
    private static final Logger log = LoggerFactory.getLogger(CryptoApplication.class);

    @Override
    public CoinDesk getCoinDeskFromApi(RestTemplate restTemplate) {
        return restTemplate.getForObject(
                "https://api.coindesk.com/v1/bpi/currentprice/BTC.json",
                CoinDesk.class);
    }
}
