package com.fooddelivery.fooddeliveryapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    /**This defines all users of the system, from system administrators,
     * restaurant owners, delivery men(women) and customers,UserRoles model
     * will be used to differentiate their role.
     * */
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String profileImage;

    public User(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String email,
            @JsonProperty("password") String password,

            /**For now user's profile image is taken as just a dummy
             * string, online image url could be passed too, it will not
             * change until proper file uploading feature is added*/
            @JsonProperty("profileImage") String profileImage
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileImage = profileImage;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getProfileImage() {
        return profileImage;
    }
}
