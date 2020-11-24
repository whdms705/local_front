package com.example.front.encryption.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class EncrypRequest {
    @NotNull
    private String isSearch = "N";

    private String plainText;
}
