package com.legotrip.user.domain.dto;


import lombok.Getter;

public class UserReqDto {

    @Getter
    public static class createUserDto{
        private String name;
        private String userId;
        private String email;
        private String password;
        private String tel;
        private String birth;
        private String mbti;
    }


}
