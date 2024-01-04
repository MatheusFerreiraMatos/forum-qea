package br.mftech.projeto.qaforum.repository;

import br.mftech.projeto.qaforum.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberRepository extends JpaRepository<Member, Long> {
    UserDetails findByUsername(String username);
}
