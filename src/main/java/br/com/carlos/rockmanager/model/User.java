package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String username;
    private String email;
    private String password_hash;
    private String role;
    private int ativo;
    private String criado_em;

}
