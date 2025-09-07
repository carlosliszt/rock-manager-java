package br.com.carlos.rockmanager.controller;

import br.com.carlos.rockmanager.model.UserInfo;
import br.com.carlos.rockmanager.service.UserService;
import br.com.carlos.rockmanager.utils.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response<Map<String, Object>>> index() {
        List<UserInfo> users = userService.listUsers();

        Map<String, Object> data = new HashMap<>();
        data.put("usuarios", users);

        Response<Map<String, Object>> resposta = new Response<>(
                true,
                "Usuários encontrados.",
                data,
                null,
                200
        );

        return ResponseEntity.status(resposta.getHttpCode()).body(resposta);
    }

}
