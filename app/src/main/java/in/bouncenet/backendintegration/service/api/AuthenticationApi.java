package in.bouncenet.backendintegration.service.api;

import in.bouncenet.backendintegration.dtos.AccessTokenByRefreshTokenRequest;
import in.bouncenet.backendintegration.dtos.AuthRequestDto;
import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.dtos.RefreshTokenResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthenticationApi {
    @POST("auth/login")
    Call<AuthResponseDto> token(@Body AuthRequestDto authRequest);

    @POST
    Call<RefreshTokenResponse> tokenByRefreshToken(
            @Body AccessTokenByRefreshTokenRequest authRequest);
}
