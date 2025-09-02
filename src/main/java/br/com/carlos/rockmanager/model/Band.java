package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Band {

    private int id;
    private String nome;
    private String pais_origem;
    private int ano_formacao;
    private String genero;

}
