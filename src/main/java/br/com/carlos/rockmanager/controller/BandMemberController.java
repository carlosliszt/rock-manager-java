package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Band;
import br.com.carlos.rockmanager.model.BandMember;
import br.com.carlos.rockmanager.service.BandMemberService;
import br.com.carlos.rockmanager.service.BandService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/bands/members")
@RestController
public class BandMemberController {

    private final BandMemberService bandMemberService;
    private final BandService bandService;

    public BandMemberController(BandMemberService bandMemberService, BandService bandService) {
        this.bandMemberService = bandMemberService;
        this.bandService = bandService;
    }

    @GetMapping
    public ResponseEntity<Response<Map<String, Object>>> index() {
        List<BandMember.BandMemberInfo> bandMembers = bandMemberService.listBandMembers();

        Map<String, Object> data = new HashMap<>();
        data.put("members", bandMembers);

        Response<Map<String, Object>> resposta = new Response<>(
                true,
                "Membros selecionados com sucesso",
                data,
                null,
                200
        );

        return ResponseEntity.status(resposta.getHttpCode()).body(resposta);
    }

    @GetMapping("/{userId}/{bandId}")
    public ResponseEntity<Response<Map<String, Object>>> show(@PathVariable Integer userId, @PathVariable Integer bandId) {
        BandMember.BandMemberInfo bandMember = bandMemberService.getBandMemberById(userId, bandId);

        Response<Map<String, Object>> response;

        if(bandMember == null) {
            response = new Response<>(false, "Não existe vínculo com os ids fornecidos",
                    null, new Response.ResponseError("validation_error", "Vínculo informado não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("member", bandMember);

        response = new Response<>(true, "Membro encontrado com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);

    }

}
