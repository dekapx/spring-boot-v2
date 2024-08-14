package com.dekapx.apps.contact.model;

import com.dekapx.apps.core.annotation.Email;
import com.dekapx.apps.core.model.BaseModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.dekapx.apps.core.common.CommonConstants.PHONE_REGEX;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ContactModel extends BaseModel {
    @Schema(description = "First Name of the contact.", required = true)
    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, max = 20, message = "First Name must be between 2 and 20 characters")
    private String firstName;

    @Schema(description = "Last Name of the contact.", required = true)
    @NotNull(message = "Last Name cannot be null")
    @Size(min = 2, max = 20, message = "Last Name must be between 2 and 20 characters")
    private String lastName;

    @Email
    @Schema(description = "Email address of the contact.", example = "someone@domain.com", required = true)
    private String email;

    @Schema(description = "Phone number of the contact.", example = "+353 (111) 222 3456", required = true)
    @Pattern(regexp = PHONE_REGEX, message = "Provide a valid phone number")
    @Size(max = 25)
    private String phone;
}
