package com.sanbro.attendence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor()//lombok lib to auto generate
@AllArgsConstructor()//lombok lib to auto generate
@Data()// lombok lib to generate getter and setters
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "Incremental")
   @GenericGenerator(name = "Incremental", strategy = "org.hibernate.id.IncrementGenerator")
    @Column(name = "id", updatable = false, nullable = false, insertable = false, unique = true)
    private Integer id;
    private String name;
    private String password;

    @Column(name = "profile_url")
    private String profileUrl;

//    @Column(name = "thumb_data")
//    private List<Integer> thumbData;

    private int otp;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return name;
    }


}
