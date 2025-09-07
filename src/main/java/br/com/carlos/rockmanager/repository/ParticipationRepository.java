package br.com.carlos.rockmanager.repository;

import br.com.carlos.rockmanager.model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipationRepository extends JpaRepository<Participation, Participation.ParticipationId> {
}
