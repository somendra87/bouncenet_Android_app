package in.bouncenet.backendintegration.service;

import in.bouncenet.backendintegration.dtos.MemberResponseDto;
import in.bouncenet.backendintegration.dtos.RegisterMemberRequestDto;
import in.bouncenet.backendintegration.repocallbacks.RepositoryCallback;

public interface MemberService {
    void register(RegisterMemberRequestDto requestDto,
                  RepositoryCallback<MemberResponseDto> callback);
}
