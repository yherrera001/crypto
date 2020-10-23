package io.yasmin.crypto.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Money {
    private String code;
    private String rate;
    private String description;
    private float rate_float;
}
