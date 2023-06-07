package com.legotrip.user.domain.entity;

import com.legotrip.user.domain.dto.UserReqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
public class User {

    private String userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String tel;
    private String birth;
    private String mbti;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder
    public User(UserReqDto.createUserDto dto, PasswordEncoder passwordEncoder){
        this.name = dto.getName();
        this.userId = dto.getUserId();
        this.email = dto.getEmail();
        this.password = passwordEncoder.encode(dto.getPassword());
        this.tel = dto.getTel();
        this.birth = dto.getBirth();
        this.mbti = dto.getMbti();

    }
}
