package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.BandMember;
import br.com.carlos.rockmanager.model.Show;
import br.com.carlos.rockmanager.service.BandMemberService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BandMemberController {

    private final BandMemberService bandMemberService;

    public BandMemberController(BandMemberService bandMemberService) {
        this.bandMemberService = bandMemberService;
    }

    @GetMapping("/bands/members")
    public ResponseEntity<Response<Map<String, Object>>> listar() {
        List<BandMember> bandMembers = bandMemberService.listBandMembers();

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

}
