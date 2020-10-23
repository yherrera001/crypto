package io.yasmin.crypto.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor@AllArgsConstructor
@ToString
public class CoinDesk {
    private Time time;
    private String disclaimer;
    private Bpi bpi;
}
