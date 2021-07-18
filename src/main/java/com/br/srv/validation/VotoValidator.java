package com.br.srv.validation;

import com.br.srv.document.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author erik_
 * Data Criacao: 17/07/2021 - 21:38
 */
@Qualifier("voto")
@Service
public class VotoValidator  implements Validator {

    @Qualifier("associado")
    @Autowired
    private Validator associadoValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return Voto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"voto",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "voto"));
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"idPauta",null,
                String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "pauta"));
        Voto voto = (Voto) target;
        if(!("SIM".equalsIgnoreCase(voto.getVoto()) || "NAO".equalsIgnoreCase(voto.getVoto()))){
            errors.rejectValue("Voto", null,String.format(MensagensConst.VOTO_INVALIDO, voto.getVoto()));
        }
        try {
            errors.pushNestedPath("associado");
            if(voto.getAssociado() != null){
                ValidationUtils.invokeValidator(this.associadoValidator, voto.getAssociado(), errors);
            }else{
                errors.reject(null, String.format(MensagensConst.ATRIBUTO_OBRIGATORIO, "associado"));
            }
        }finally {
            errors.popNestedPath();
        }
    }
}
