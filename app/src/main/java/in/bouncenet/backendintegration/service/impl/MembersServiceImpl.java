package in.bouncenet.backendintegration.service.impl;

import static android.content.ContentValues.TAG;

import android.util.Log;

import in.bouncenet.backendintegration.client.RetrofitClient;
import in.bouncenet.backendintegration.dtos.RegisterMemberRequestDto;
import in.bouncenet.backendintegration.dtos.MemberResponseDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;
import in.bouncenet.backendintegration.service.MemberService;
import in.bouncenet.backendintegration.service.api.MembersApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MembersServiceImpl implements MemberService {

    private final MembersApi membersApi;

    public MembersServiceImpl() {
        this.membersApi = RetrofitClient.getRetrofitClient().create(MembersApi.class);
    }

    @Override
    public void register(RegisterMemberRequestDto requestDto,
                         RepositoryCallback<MemberResponseDto> callback) {
        membersApi.registerMember(requestDto).enqueue(
                new Callback<MemberResponseDto>() {
                    @Override
                    public void onResponse(Call<MemberResponseDto> call, Response<MemberResponseDto> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            callback.onSuccess(response.body());
                        } else {
                            callback.onFailure(
                                    response.body() != null
                                            ? response.body().getStatus()
                                            : "Registration Failed"
                            );
                        }
                    }

                    @Override
                    public void onFailure(Call<MemberResponseDto> call, Throwable throwable) {
                        Log.i(TAG, "onFailure: " + throwable.getLocalizedMessage());
                        callback.onFailure("Network Error. Pleas check you connection");
                    }
                }
        );


    }
}
