package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Band;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    private final JdbcTemplate jdbcTemplate;

    public BandService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Band> listBands() {
        String sql = "SELECT * FROM banda";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Band(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("pais_origem"),
                rs.getInt("ano_formacao"),
                rs.getString("genero")
        ));
    }

}
