package br.com.carlos.rockmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private int id;
    private String username;
    private String email;
    private String password_hash;
    private String role;
    private int ativo;
    private String criado_em;

}
