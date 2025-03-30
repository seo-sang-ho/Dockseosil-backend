package ChatProject.DockSeosil.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ChatProject.DockSeosil.member.Entity.Member;
import ChatProject.DockSeosil.member.Entity.SignupRequestDto;
import ChatProject.DockSeosil.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public void signup(SignupRequestDto request) {
		if (memberRepository.findByUsername(request.getUsername()).isPresent()) {
			throw new IllegalStateException("이미 존재하는 사용자입니다.");
		}

		Member member = Member.builder()
			.username(request.getUsername())
			.password(passwordEncoder.encode(request.getPassword()))
			.email(request.getEmail())
			.build();

		memberRepository.save(member);
	}
}
