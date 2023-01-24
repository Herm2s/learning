package com.hermes.springsecurity1.controller;

import com.hermes.springsecurity1.util.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    public JsonResult<String> index() {
        return JsonResult.success("成功", "欢迎来到首页！");
    }
}
