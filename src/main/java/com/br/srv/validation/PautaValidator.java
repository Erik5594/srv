package com.br.srv.validation;

import com.br.srv.document.Pauta;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 16:10
 */
@Qualifier("pauta")
@Service
public class PautaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Pauta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"assunto",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "assunto"));
    }
}