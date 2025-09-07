package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.Show;
import br.com.carlos.rockmanager.service.ShowService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/shows")
@RestController
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public ResponseEntity<Response<Map<String, Object>>> index() {
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

    @GetMapping("/{id}")
    public ResponseEntity<Response<Map<String, Object>>> show(@PathVariable Integer id) {
        Show show = showService.getShowById(id);

        Response<Map<String, Object>> response;

        if(show == null) {
            response = new Response<>(false, "Não existe um show com o id fornecido",
                    null, new Response.ResponseError("validation_error", "Show informado não existente"), 404);
            return ResponseEntity.status(response.getHttpCode()).body(response);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("shows", show);

        response = new Response<>(true, "Show encontrado com sucesso", data, null, 200);

        return ResponseEntity.status(response.getHttpCode()).body(response);
    }

}
