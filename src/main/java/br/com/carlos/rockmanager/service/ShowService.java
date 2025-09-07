package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Show;
import br.com.carlos.rockmanager.repository.ShowRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> listShows() {
        return showRepository.findAll();
    }

    public Show getShowById(int id) {
        return showRepository.findById(id).orElse(null);
    }

}
