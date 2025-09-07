package br.com.carlos.rockmanager.repository;

import br.com.carlos.rockmanager.model.BandMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BandMemberRepository extends JpaRepository<BandMember, BandMember.BandMemberId> {

    @Query(value = "SELECT ub.id_usuario, u.username AS nome_usuario, ub.id_banda, b.nome AS nome_banda, ub.funcao " +
            "FROM usuariobanda ub " +
            "JOIN usuarios u ON ub.id_usuario = u.id " +
            "JOIN banda b ON ub.id_banda = b.id", nativeQuery = true)
    List<Object[]> findBandMembers();

    @Query(value = "SELECT ub.id_usuario, u.username AS nome_usuario, ub.id_banda, b.nome AS nome_banda, ub.funcao " +
            "FROM usuariobanda ub " +
            "JOIN usuarios u ON ub.id_usuario = u.id " +
            "JOIN banda b ON ub.id_banda = b.id WHERE id_banda = :bandId", nativeQuery = true)
    List<Object[]> findMembersByBandId(@Param("bandId") int bandId);

    @Query(value = "SELECT ub.id_usuario, u.username AS nome_usuario, ub.id_banda, b.nome AS nome_banda, ub.funcao " +
            "FROM usuariobanda ub " +
            "JOIN usuarios u ON ub.id_usuario = u.id " +
            "JOIN banda b ON ub.id_banda = b.id WHERE id_banda = :bandId AND id_usuario = :userId", nativeQuery = true)
    List<Object[]> findBandMemberById(@Param("bandId") int bandId, @Param("userId") int userId);

}
