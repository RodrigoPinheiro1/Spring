package controller.Config;

import lombok.Getter;

import javax.management.ConstructorParameters;

@Getter
public class ErroDeFormularioDto {

    private String campo;
    private String erro;


    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
