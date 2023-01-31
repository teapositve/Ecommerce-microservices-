package org.nagarro.ProductMicroservice.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {

    public String message;
    public boolean success;
}
