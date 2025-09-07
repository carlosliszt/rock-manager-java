package br.com.carlos.rockmanager.service;

import br.com.carlos.rockmanager.model.User;
import br.com.carlos.rockmanager.model.UserInfo;
import br.com.carlos.rockmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserInfo> listUsers() {
        return userRepository.findAll().stream().map(user -> new UserInfo(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                "",
                user.getRole(),
                user.getAtivo(),
                user.getCriado_em()
        )).collect(Collectors.toList());
    }

}
