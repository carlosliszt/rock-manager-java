package br.com.carlos.rockmanager.repository;

import br.com.carlos.rockmanager.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
