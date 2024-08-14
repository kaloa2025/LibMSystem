package com.example.LibMSystem.dto;

import com.example.LibMSystem.model.User;
import com.example.LibMSystem.model.UserStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequest {
    private String userName;
    @NotBlank(message = "PhoneNo must be unique")
    private String phoneNo;
    @NotBlank(message = "Password incorrect")
    private String password;
    private String email;
    private String address;
    public User toUser()
    {
        return User.builder()
                .name(this.userName)
                .email(this.email)
                .phoneNo(this.phoneNo)
                .address(this.address)
                .userStatus(UserStatus.ACTIVE)
                .build();
    }
}
