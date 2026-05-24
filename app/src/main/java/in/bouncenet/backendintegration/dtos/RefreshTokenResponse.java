package in.bouncenet.backendintegration.dtos;

/*
{
    "memberId": "b70a7755-491b-443f-a056-d4b338247a9c",
    "accessToken": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiNzBhNzc1NS00OTFiLTQ0M2YtYTA1Ni1kNGIzMzgyNDdhOWMiLCJpYXQiOjE3NzkxMzU5NDksImV4cCI6MTc3OTEzNjg0OSwicm9sZXMiOlsiUk9MRV9NRU1CRVIiXX0.DvJrc-GTHlXh44eFqJfALc--XrTzkAYgfx6bvujiAYn6sBmMiBeDRi3Svx4Vd_Jdha-1QQwkbqcqk_NwacKY-KxMunwEXqC89syA8cc6QdMgipvCwhVlDx18EuBulCXu8e_WRTZp242oYOgMG3snsB3WLq1UG3KIlFpurIMRes3hC_1fa82Ukb114XPvgBYWwn07419eKnR0Z6nueYeYBqfQjmkvZX_ZliCwznz2OeqvqDIK3_0YOK7LYChC1XqaZFjUh3pVp8yH19EH6Lxx46IGmefUV_lMVL3lrhqIqbwulthbyDboQ6D_jxk_h1tUR5bQPHVrQrrtcUkSgFilaw",
    "refreshToken": "87ab5931-8404-4141-8b5c-56635a1ad6f9"
}
 */
public record RefreshTokenResponse(
        String memberId,
        String accessToken,
        String refreshToken
) { }
