package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Participation {

    private int id_banda;
    private int id_show;
    private int ordem_apresentacao;
    private int tempo_execucao_min;

}
