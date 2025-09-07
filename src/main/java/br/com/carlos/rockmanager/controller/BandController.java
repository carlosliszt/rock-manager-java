package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Band;
import br.com.carlos.rockmanager.model.BandMember;
import br.com.carlos.rockmanager.model.Participation;
import br.com.carlos.rockmanager.service.BandMemberService;
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

@RequestMapping("/bands")
@RestController
public class BandController {

    private final BandService bandService;
    private final BandMemberService bandMemberService;
    private final ParticipationService participationService;

    public BandController(BandService bandService, BandMemberService bandMemberService, ParticipationService participationService) {
        this.bandService = bandService;
        this.bandMemberService = bandMemberService;
        this.participationService = participationService;
    }

    @GetMapping
    public ResponseEntity<Response<Map<String, Object>>> index() {
        List<Band> bandas = bandService.listBands();

        Map<String, Object> data = new HashMap<>();
        data.put("bandas", bandas);

        Response<Map<String, Object>> resposta = new Response<>(
                true,
                "Bandas selecionadas com sucesso",
                data,
                null,
                200
        );

        return ResponseEntity.status(resposta.getHttpCode()).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Map<String, Object>>> show(@PathVariable Integer id) {
        Band band = bandService.getBandById(id);

        Response<Map<String, Object>> response;

        if(band == null) {
            response = new Response<>(false, "Não existe uma banda com o id fornecido",
                    null, new Response.ResponseError("validation_error", "Banda informada não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("bandas", band);

        response = new Response<>(true, "Banda encontrada com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);

    }

    @GetMapping("/{id}/members")
    public ResponseEntity<Response<Map<String, Object>>> showMembers(@PathVariable Integer id) {
        List<BandMember.BandMemberInfo> bandMembers = bandMemberService.getBandMembersByBandId(id);

        Band band = bandService.getBandById(id);

        Response<Map<String, Object>> response;

        if(band == null) {
            response = new Response<>(false, "Não existe uma banda com o id fornecido",
                    null, new Response.ResponseError("validation_error", "Banda informada não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        if(bandMembers.isEmpty()) {
            response = new Response<>(false, "A banda não possui membros",
                    null, new Response.ResponseError("validation_error", "Nenhum membro encontrado para a banda informada"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("id_banda", band.getId());
        data.put("nome_banda", band.getNome());
        data.put("membros", bandMembers);

        response = new Response<>(true, "Membros da banda selecionados com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);

    }

    @GetMapping("/{id}/shows")
    public ResponseEntity<Response<Map<String, Object>>> showParticipations(@PathVariable Integer id) {
        List<Participation> participation = participationService.getParticipationsByBandId(id);

        Band band = bandService.getBandById(id);

        Response<Map<String, Object>> response;


        if (band == null) {
            response = new Response<>(false, "Não existe uma banda com o id fornecido",
                    null, new Response.ResponseError("validation_error", "Banda informada não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        if(participation.isEmpty()) {
            response = new Response<>(false, "A banda não possui shows cadastrados",
                    null, new Response.ResponseError("banda_sem_shows", "Nenhum show encontrado para a banda informada"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();

        data.put("id_banda", band.getId());
        data.put("nome_banda", band.getNome());
        data.put("shows", participation);

        response = new Response<>(true, "Shows da banda encontrados com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);

    }

}
