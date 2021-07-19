package com.br.srv.validation;

import com.br.srv.document.Pauta;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 16:10
 */
@Qualifier("pautaAtiva")
@Service
public class PautaAtivaValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Pauta.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Pauta pauta = (Pauta) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "id"));

        if(!(pauta.getFimSessao().after(new Date()) && pauta.getInicioSessao().before(new Date()))){
            errors.reject(null, MensagensConst.PAUTA_INDISPONIVEL);
        }

    }

}