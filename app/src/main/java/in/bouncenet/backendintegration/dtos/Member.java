package in.bouncenet.backendintegration.dtos;

/**
 * "member": {
 * "memberId": "b70a7755-491b-443f-a056-d4b338247a9c",
 * "email": "somendra5101987@yopmail.com",
 * "firstName": "Somendra",
 * "status": "ACTIVE"
 * }
 */
public record Member(
        String memberId,
        String email,
        String firstName,
        String status) { }
