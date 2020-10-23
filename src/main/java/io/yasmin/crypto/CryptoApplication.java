package io.yasmin.crypto;

import io.yasmin.crypto.model.CoinDesk;
import io.yasmin.crypto.model.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@SpringBootApplication
@EnableScheduling
public class CryptoApplication {
	private static final Logger log = LoggerFactory.getLogger(CryptoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;

	@Scheduled(fixedDelay = 5000)
	public void executeTaskToGetCoinDesk(){
		log.info(restTemplate+""); //
		CoinDesk coinDesk = getCoinDeskFromApi(restTemplate);
		log.info(coinDesk.toString());
	}



	//fetching
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//Add the Jackson Message converter
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response,
// not only application/*json, which is the default behaviour
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		return builder
				.defaultHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
				.defaultHeader("Content-Type","application/json")
				.additionalMessageConverters(messageConverters)
				.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			CoinDesk quote = getCoinDeskFromApi(restTemplate);
			log.info(quote.toString());
		};
	}

	private CoinDesk getCoinDeskFromApi(RestTemplate restTemplate) {
		return restTemplate.getForObject(
				"https://api.coindesk.com/v1/bpi/currentprice/BTC.json",
				CoinDesk.class);
	}

}
