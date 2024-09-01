package com.sanbro.attendence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor()//lombok lib to auto generate
@AllArgsConstructor()//lombok lib to auto generate
@Data()// lombok lib to generate getter and setters
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String name;
    private String password;
    private String profileUrl;
    private List<Integer> thumbData;
    private int otp;
}
