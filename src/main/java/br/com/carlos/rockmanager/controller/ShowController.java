package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Show;
import br.com.carlos.rockmanager.service.ShowService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/shows")
    public ResponseEntity<Response<Map<String, Object>>> listar() {
        List<Show> shows = showService.listShows();

        Map<String, Object> data = new HashMap<>();
        data.put("shows", shows);

        Response<Map<String, Object>> resposta = new Response<>(
                true,
                "Shows selecionados com sucesso",
                data,
                null,
                200
        );

        return ResponseEntity.status(resposta.getHttpCode()).body(resposta);
    }

}
