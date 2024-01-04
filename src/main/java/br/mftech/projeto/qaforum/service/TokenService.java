package br.mftech.projeto.qaforum.service;

import br.mftech.projeto.qaforum.model.Member;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Member member) {
        return JWT.create()
                .withIssuer("Topics")
                .withSubject(member.getUsername())
                .withClaim("id", member.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("teste"));
    }

}
