package in.bouncenet.backendintegration.service.impl;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;

import in.bouncenet.backendintegration.client.RetrofitClient;
import in.bouncenet.backendintegration.dtos.AccessTokenByRefreshTokenRequest;
import in.bouncenet.backendintegration.dtos.AuthRequestDto;
import in.bouncenet.backendintegration.dtos.AuthResponseDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;
import in.bouncenet.backendintegration.service.AuthenticationService;
import in.bouncenet.backendintegration.service.api.AuthenticationApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationApi authenticationApi;

    public AuthenticationServiceImpl() {
        this.authenticationApi = RetrofitClient.getRetrofitClient().create(AuthenticationApi.class);
    }

    @Override
    public void token(AuthRequestDto authRequestDto,
                      RepositoryCallback<AuthResponseDto> authCallback) {

        authenticationApi.token(authRequestDto).enqueue(
                new Callback<AuthResponseDto>() {
                    @Override
                    public void onResponse(Call<AuthResponseDto> call,
                                           Response<AuthResponseDto> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            authCallback.onSuccess(response.body());
                        } else {
                            authCallback.onFailure(
                                    null != response.body()
                                            ? response.body().member().memberId()
                                            : "Login Failed"

                            );
                        }

                    }

                    @Override
                    public void onFailure(Call<AuthResponseDto> call, Throwable t) {

                        Log.i("LOGIN_FAILED_OP", "LoginFailed: " + t.getLocalizedMessage());
                        authCallback.onFailure("Network Error. Pleas check you connection");
                    }
                });

    }

    @Override
    public void tokenByRefreshToken(AccessTokenByRefreshTokenRequest refreshTokenRequest,
                                    RepositoryCallback<AuthResponseDto> authCallback) {

    }
}
