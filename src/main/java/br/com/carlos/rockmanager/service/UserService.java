package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> listUsers() {
        String sql = "SELECT * FROM usuarios ORDER BY id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                "", // sem retornar senha por motivo de segurança.
                rs.getString("role"),
                rs.getInt("ativo"),
                rs.getString("criado_em")
        ));
    }

}
