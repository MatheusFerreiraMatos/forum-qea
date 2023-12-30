package br.mftech.projeto.qaforum.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorRequest {

    private String field;
    private String error;

}
