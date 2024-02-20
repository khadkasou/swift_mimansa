package com.swift.mimansa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "first_name")
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    private String firstName;

    @Column(name = "middle_name")
    @Size(min = 2, max = 50, message = "Middle name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Middle name must contain only letters")
    private String middleName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters")
    private String lastName;
    @Column(name = "date_of_birth")
    @Past(message = "Date of Birth must be in the past")
    @NotNull(message = "Date of Birth is required")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Pattern(regexp = "^(Male|Female|Other)$",
            message = "Invalid gender. Allowed values: Male, Female, Other")
    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    @NotBlank(message = "Address must not be blank")
    @Size(max = 255, message = "Address must be less than or equal to 255 characters")
    private String address;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\+?[0-9\\-\\s]+$", message = "Phone number format is invalid")
    private String phoneNumber;

    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
            message = "Please provide a valid email address")
    private String email;


}
