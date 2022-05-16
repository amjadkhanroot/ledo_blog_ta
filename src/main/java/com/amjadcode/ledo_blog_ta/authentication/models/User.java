package com.amjadcode.ledo_blog_ta.authentication.models;

import com.amjadcode.ledo_blog_ta.posts.models.Post;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lendo_blog_users")
public class User implements UserDetails {

    private static final int MIN_USERNAME_LENGTH = 3;
    private static final int MIN_PASSWORD_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = MIN_USERNAME_LENGTH, message = "name must be at least " + MIN_USERNAME_LENGTH + " characters long")
    @NotEmpty(message = "Please enter your name")
    @Column(nullable = false, unique = true)
    private String username;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @JsonIgnore
    @Length(min = MIN_PASSWORD_LENGTH, message = "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long")
    @NotEmpty(message = "Please enter the password")
    @Column(nullable = false)
    private String password;
    @JsonIgnore
    @Column(columnDefinition = "BIT default 1")
    private Boolean active;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getEmail(), user.getEmail()) && getGender() == user.getGender() && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getActive(), user.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getEmail(), getGender(), getPassword(), getActive());
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Transient
    @Override
    public String getUsername() {
        return this.username;
    }
    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }
    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }
    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }
    @Transient
    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
