package ChatProject.DockSeosil.member.Entity;

// import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor // 모든 필드 받는 생성자
@NoArgsConstructor // JPA 프록시 생성을 위한 기본 생성자
public class Member {

	@Id @GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private String email;

	// 비밀번호 암호화
	// public void encodePassword(PasswordEncoder passwordEncoder){
	// 	this.password = passwordEncoder.encode(this.password);
	// }
}
