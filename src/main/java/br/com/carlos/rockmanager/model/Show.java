package br.com.carlos.rockmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String local;
    private String data;
    private int publico_estimado;

}
