package com.chelyadin.test.address_book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dmitriy Chelyadin
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
