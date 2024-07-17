package com.example.LibMSystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnRequest {
    @NotBlank(message = "Invalid PhoneNo")
    private String userPhoneNo;
    @NotBlank(message = "Invalid BookNo")
    private String bookNo;
}
