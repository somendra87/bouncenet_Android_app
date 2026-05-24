package in.bouncenet.backendintegration.dtos;

/**
 * {
 * "tokenType": "Bearer",
 * "accessToken": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiNzBhNzc1NS00OTFiLTQ0M2YtYTA1Ni1kNGIzMzgyNDdhOWMiLCJpYXQiOjE3NzkxMzU4ODcsImV4cCI6MTc3OTEzNjc4Nywicm9sZXMiOlsiUk9MRV9NRU1CRVIiXX0.X9yD24f3_ISuMKKf6Cm55UucExFIANKmTDJVXc7U4NuXl1pKl98utXE2Kv5yVS_dq9s8HWL_Bii7I7nsgUUd6wjdNcKMugIIbfEbGowzdr8_5MD_k0pwqfUUBIxbYH3F90Ee3awvLlncegGQjJbazoG8TJUBIHhlgMNBAhBM9sJeW7KjOERTfANFzIPWCSCc1IRI4YAvLfW0pWVLKPiaGZjxg2lUg-0hBn2rjwgnhk1oxcamPKlYQ55pR7M2KxtYYqG63ijyoaF8VUAFbVZCI7nPPLZ52ayC7if1AQ7Hbv54pHn-BgM_sb9WFj_e8n3JYSFiFJEo4Awq59wjw2c2Zw",
 * "refreshToken": "18a6d5ff-dbbd-4798-9313-089eb8fdac75",
 * "member": {
 * "memberId": "b70a7755-491b-443f-a056-d4b338247a9c",
 * "email": "somendra5101987@yopmail.com",
 * "firstName": "Somendra",
 * "status": "ACTIVE"
 * }
 * }
 */
public record AuthResponseDto(
        String tokenType,
        String accessToken,
        String refreshToken,
        Member member) {
}
