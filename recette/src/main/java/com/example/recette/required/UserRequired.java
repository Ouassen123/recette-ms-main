package com.example.recette.required;

import com.example.recette.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
@FeignClient(name = "USER-MS",url = "${userUrl}")
public interface UserRequired {
    @GetMapping("/ref/{ref}")
    public UserVo findByRef(@PathVariable String ref);
    @GetMapping("/email/{email}")
    public UserVo findByEmail(@PathVariable String email);
}
