package io.yasmin.crypto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bpi {
//THE @JSONPROPERTY SCANS ALL THE DATA AND LOOKS FOR THE SPECIFIC PROPERTY THAT YOU PASS IN
    @JsonProperty("USD")
    private Money usd;

    @JsonProperty("BTC")
    private Money btc;
}
