package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.Participation;
import br.com.carlos.rockmanager.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {

    private final ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public List<Participation> listParticipations() {
        return participationRepository.findAll();
    }

    public List<Participation> getParticipationsByBandId(int bandId) {
        return participationRepository.findAll().stream()
                .filter(participation -> participation.getId_banda() == bandId)
                .toList();
    }

    public Participation getParticipationById(int showId, int bandId) {
        Participation.ParticipationId participationId = new Participation.ParticipationId();

        participationId.setId_banda(bandId);
        participationId.setId_show(showId);

        return participationRepository.findById(participationId).orElse(null);

    }

}
