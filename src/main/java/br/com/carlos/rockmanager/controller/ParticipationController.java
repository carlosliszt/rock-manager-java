package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Participation;
import br.com.carlos.rockmanager.model.Show;
import br.com.carlos.rockmanager.service.ParticipationService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParticipationController {

    private final ParticipationService participationService;

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @GetMapping("/participacoes")
    public ResponseEntity<Response<Map<String, Object>>> listar() {
        List<Participation> participations = participationService.listParticipations();

        Map<String, Object> data = new HashMap<>();
        data.put("participacoes", participations);

        Response<Map<String, Object>> resposta = new Response<>(
                true,
                "Participações selecionados com sucesso",
                data,
                null,
                200
        );

        return ResponseEntity.status(resposta.getHttpCode()).body(resposta);
    }

}
