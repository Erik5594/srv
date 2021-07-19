package com.br.srv.validation;

import com.br.srv.document.Associado;
import com.br.srv.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 23:20
 */
@Qualifier("associado")
@Service
public class AssociadoValidator implements Validator {

    @Autowired
    private AssociadoService service;

    @Override
    public boolean supports(Class<?> clazz) {
        return Associado.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Associado associado = (Associado) target;
        associado.setStatus(service.consultarCpf(associado.getCnpjCpf()));

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nome",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "nome"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"cnpjCpf",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "cnpjCpf"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"status",null,
                String.format(MensagensConst.CPF_INVALIDO, associado.getCnpjCpf()));

        if("UNABLE_TO_VOTE".equalsIgnoreCase(associado.getStatus())){
            errors.rejectValue("status", null, MensagensConst.NAO_HABILITADO);
        }
    }
}
