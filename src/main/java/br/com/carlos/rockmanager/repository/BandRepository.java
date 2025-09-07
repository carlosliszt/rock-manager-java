package br.com.carlos.rockmanager.repository;

import br.com.carlos.rockmanager.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BandRepository extends JpaRepository<Band, Integer> {

}
