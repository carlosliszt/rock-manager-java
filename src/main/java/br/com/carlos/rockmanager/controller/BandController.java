package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Band;
import br.com.carlos.rockmanager.service.BandService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BandController {

    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping("/bands")
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

    @GetMapping("/bands/{id}")
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

}
