package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Band;
import br.com.carlos.rockmanager.repository.BandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BandService {

    private final BandRepository bandRepository;

    public BandService(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    public List<Band> listBands() {
        return bandRepository.findAll();
    }

    public Band getBandById(int id) {
        return bandRepository.findById(id).orElse(null);
    }

}
