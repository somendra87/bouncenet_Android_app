package in.bouncenet.backendintegration.service;

import in.bouncenet.backendintegration.dtos.AccessTokenByRefreshTokenRequest;
import in.bouncenet.backendintegration.dtos.AuthRequestDto;
import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;

public interface AuthenticationService {
    void token(AuthRequestDto authRequestDto,
               RepositoryCallback<AuthResponseDto> authCallback);

    void tokenByRefreshToken(AccessTokenByRefreshTokenRequest refreshTokenRequest,
                             RepositoryCallback<AuthResponseDto> authCallback);
}
