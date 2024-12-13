package ForoHub.Blog.Domain.DTOs;

import ForoHub.Blog.Domain.Models.users.RoleUser;
import ForoHub.Blog.Domain.Models.users.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

        @NotBlank
        private String firstName;
        private String lastName;
        @NotBlank
        private String phone;
        @Email
        @NotNull
        private String email;
        @NotNull
        private String password;
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        private String document;
        @NotNull
        RoleUser roleUser;

        public Users validateModeluser() {
                return new Users(
                                null,
                                this.firstName,
                                this.lastName,
                                this.phone,
                                this.email,
                                this.password,
                                this.document,
                                this.roleUser,
                                // User active for default
                                true
                );

        }

}
