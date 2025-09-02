package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.BandMember;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandMemberService {

    private final JdbcTemplate jdbcTemplate;

    public BandMemberService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //workaround for now.
    public List<BandMember> listBandMembers() {
        String sql = "SELECT ub.id_usuario, u.username AS nome_usuario, ub.id_banda, b.nome AS nome_banda, ub.funcao " +
                "FROM usuariobanda ub " +
                "JOIN usuarios u ON ub.id_usuario = u.id " +
                "JOIN banda b ON ub.id_banda = b.id " +
                "ORDER BY ub.id_usuario";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new BandMember(
                rs.getInt("id_usuario"),
                rs.getString("nome_usuario"),
                rs.getInt("id_banda"),
                rs.getString("nome_banda"),
                rs.getString("funcao")
        ));
    }

}

