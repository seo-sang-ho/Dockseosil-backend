package ChatProject.DockSeosil.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ChatProject.DockSeosil.member.Entity.SignupRequestDto;
import ChatProject.DockSeosil.member.service.AuthService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody SignupRequestDto request){
		authService.signup(request);
		return ResponseEntity.ok("회원가입 성공");
	}
}
