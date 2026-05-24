package in.bouncenet.backendintegration.dtos;

/**
 * {
 *     "memberId": "b70a7755-491b-443f-a056-d4b338247a9c",
 *     "firstName": "Somendra",
 *     "email": "somendra5101987@yopmail.com",
 *     "phone": "7760036435",
 *     "status": "ACTIVE",
 *     "accessToken": "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiNzBhNzc1NS00OTFiLTQ0M2YtYTA1Ni1kNGIzMzgyNDdhOWMiLCJpYXQiOjE3NzkwNzk5MDUsImV4cCI6MTc3OTA4MDgwNSwicm9sZXMiOlsiUk9MRV9NRU1CRVIiXX0.PHZQbL09YtnqS8ZL5fiETN_U4lnkl_XMmlM5vLLP2LBPMqI_nWj1h_jygROxZm9ZOO2i_PKQIzIWQbOiHNM-i670FXXiNUGO18zVxBTbfUGXPBb3q1pEqQp0hNCLh9Z-tcZenew2mOd_nULp-pjt5_I6FnKpDmwsOWS5KKFF2IQZ9vflkj_SPur6tN-nO7Eqx1xKbHIAGMqQNZ72cBP-XQGN55drhniqZzSbKfVKZyJF-jOgHm7S36b-ZqTQ1d1wL0Qye_i81FlI-OIFYTwoAAXtmw-sxcDWWJfGH1otoxo1AYUx0KNp6gPJvxiuQ26Vd9_GPChbTT1XK-JOSSmuTw",
 *     "refreshToken": "d7a63419-6621-4676-ab81-09b737d9938c"
 * }
 */
public class MemberResponseDto {
    private String memberId;
    private String firstName;
    private String email;
    private String phone;
    private String status;
    private String accessToken;
    private String refreshToken;

    public MemberResponseDto() {
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
