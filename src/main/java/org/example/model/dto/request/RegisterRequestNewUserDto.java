package org.example.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestNewUserDto {

    @NotNull(message = "Field couldn't be null")
//    @Pattern(regexp = "^(?=^.{1,30}$)[А-ЯЁA-Z](([-'\\sА-ЯЁA-Zа-яёa-z])*[А-ЯЁA-Zа-яёa-z])?$",
//            message = "First name must starts with capital letter, have the length of 1 to 30 and might include " +
//                    "- ' and space character and can't end with these characters")
    private String name;
    @NotNull(message = "Field couldn't be null")
//    @Pattern(regexp = "^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*[!#$%&'()*+,\\-./:;<=>\\[?@\\]^_`{|}~])" +
//            "[a-zA-Z0-9!#$%&'()*+,\\-./:;<=>\\[?@\\]^_`{|}~]{6,20}$",
//            message = "Password must contain 6 to 20 symbols, 1 uppercase and 1 lowercase letter, 1 digit and 1 special character")
    private String password;
}
