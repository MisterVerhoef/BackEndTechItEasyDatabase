package nl.novi.backend.techiteasy.Dto;

public class UserDto {
    @NotBlank
    String userName;


    @NotBlank
    @Size(min=6, max=30)
    public String password;


    @NotBlank
    @Email
    String email;



}
