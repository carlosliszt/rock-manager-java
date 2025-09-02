package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Participation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {

    private final JdbcTemplate jdbcTemplate;

    public ParticipationService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Participation> listParticipations() {
        String sql = "SELECT * FROM participacao ORDER BY id_banda";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Participation(
                rs.getInt("id_banda"),
                rs.getInt("id_show"),
                rs.getInt("ordem_apresentacao"),
                rs.getInt("tempo_execucao_min")
        ));
    }

}
