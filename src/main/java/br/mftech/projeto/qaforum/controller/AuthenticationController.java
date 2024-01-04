package br.mftech.projeto.qaforum.controller;

import br.mftech.projeto.qaforum.controller.dto.request.Login;
import br.mftech.projeto.qaforum.model.Member;
import br.mftech.projeto.qaforum.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/auth")
    public String login(@RequestBody Login login) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.username(), login.password());

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var member = (Member) authenticate.getPrincipal();

        return tokenService.gerarToken(member);

    }
}
