package com.example.recette.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private int id;
    private String ref;
    private String nom;
    private String prenom;
    private String email;
    private String password;
}
