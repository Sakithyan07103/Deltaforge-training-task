package com.sakithyan.miniproject.E_Commerce.Management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private int customerId;

    @NonNull
    private String customerUserName;

    @NonNull
    private String customerPassword;

    @NonNull
    private String customerEmail;
}
