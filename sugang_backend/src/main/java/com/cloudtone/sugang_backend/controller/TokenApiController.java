package com.cloudtone.sugang_backend.controller;

import com.cloudtone.sugang_backend.dto.CreateAccessTokenRequest;
import com.cloudtone.sugang_backend.dto.CreateAccessTokenResponse;
import com.cloudtone.sugang_backend.service.TokenService;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenRequest request){
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponse(newAccessToken));
    }
}
