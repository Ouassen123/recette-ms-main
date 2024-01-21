package com.example.recette.vo;

import com.example.recette.bean.Recette;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity {
    Recette recette;
    UserVo userVo;
}
