package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Show;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final JdbcTemplate jdbcTemplate;

    public ShowService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> listShows() {
        String sql = "SELECT * FROM shows ORDER BY id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Show(
                rs.getInt("id"),
                rs.getString("local"),
                rs.getString("data"),
                rs.getInt("publico_estimado")
        ));
    }

}
