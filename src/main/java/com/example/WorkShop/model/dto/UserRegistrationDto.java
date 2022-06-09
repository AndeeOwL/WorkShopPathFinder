package com.example.WorkShop.model.dto;


import javax.validation.constraints.*;

public class UserRegistrationDto {

    @NotBlank
    @Size(min = 5,max = 20)
    private String username;

    @NotBlank
    @Size(min = 5,max = 20)
    private String fullname;

    @NotBlank
    @Email
    private String email;

    @Min(1)
    @Max(90)
    private int age;

    @NotBlank
    @Size(min = 5,max = 20)
    private String password;

    @NotBlank
    @Size(min = 5,max = 20)
    private String confirmPassword;

    public UserRegistrationDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmedPassword) {
        this.confirmPassword = confirmedPassword;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "name='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
