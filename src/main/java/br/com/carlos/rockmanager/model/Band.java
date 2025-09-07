package br.com.carlos.rockmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String pais_origem;
    private int ano_formacao;
    private String genero;

}
