package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Band;
import br.com.carlos.rockmanager.model.Participation;
import br.com.carlos.rockmanager.service.BandService;
import br.com.carlos.rockmanager.service.ParticipationService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/participacoes")
@RestController
public class ParticipationController {

    private final ParticipationService participationService;
    private final BandService bandService;

    public ParticipationController(ParticipationService participationService, BandService bandService) {
        this.participationService = participationService;
        this.bandService = bandService;
    }

    @GetMapping
    public ResponseEntity<Response<Map<String, Object>>> index() {
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

    @GetMapping("/{bandId}/{showId}")
    public ResponseEntity<Response<Map<String, Object>>> show(@PathVariable Integer bandId, @PathVariable Integer showId) {
        Participation participation = participationService.getParticipationById(showId, bandId);

        Response<Map<String, Object>> response;

        if(participation == null) {
            response = new Response<>(false, "Não existe uma participação com os ids fornecidos",
                    null, new Response.ResponseError("validation_error", "Participação informada não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("participacao", participation);

        response = new Response<>(true, "Participação encontrada com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);

    }



}
