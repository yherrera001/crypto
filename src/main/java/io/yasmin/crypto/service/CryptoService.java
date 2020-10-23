package io.yasmin.crypto.service;

import io.yasmin.crypto.model.CoinDesk;
import org.springframework.web.client.RestTemplate;

public interface CryptoService {
    CoinDesk getCoinDeskFromApi(RestTemplate restTemplate);
}
