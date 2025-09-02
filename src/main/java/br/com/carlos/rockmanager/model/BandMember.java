package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class BandMember {

    private int id_usuario;
    private String nome_usuario;
    private int id_banda;
    private String nome_banda;
    private String funcao;

}
