package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Show {

    private int id;
    private String local;
    private String data;
    private int publico_estimado;

}
