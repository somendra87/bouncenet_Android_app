package in.bouncenet.backendintegration.service.api;

import in.bouncenet.backendintegration.dtos.RegisterMemberRequestDto;
import in.bouncenet.backendintegration.dtos.MemberResponseDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MembersApi {
    @POST("members")
    Call<MemberResponseDto> registerMember(@Body RegisterMemberRequestDto registerMemberRequestDto);
}
