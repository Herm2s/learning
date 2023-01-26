package com.hermes.springsecurity1.controller;

import com.hermes.springsecurity1.service.HomeService;
import com.hermes.springsecurity1.util.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu.zongbin
 * @since 2023/1/23
 */
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @GetMapping("/index")
    public JsonResult<String> index() {
        return JsonResult.success("成功", homeService.sayHello());
    }
}
