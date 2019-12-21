package com.ltaocs.draft.front;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 11:11 AM
 */

@RestController
public class FrontSolution {
    @RequestMapping("/param")
    @ResponseBody
    public String find(String id) {
        return "test";
    }

}
