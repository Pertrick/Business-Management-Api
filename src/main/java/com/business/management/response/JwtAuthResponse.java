package com.business.management.response;

import com.business.management.security.JWTAuthenticationFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    private String errorMessage;

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public JwtAuthResponse(String errorMessage, boolean isError){
        this.accessToken = null;
        this.tokenType = null;
        this.errorMessage = errorMessage;
    }



}
