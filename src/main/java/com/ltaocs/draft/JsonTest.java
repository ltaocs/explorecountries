package com.ltaocs.draft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Lin Tao
 * @Date: 12/21/2019 6:49 AM
 */
@RestController
public class JsonTest {

    @GetMapping(value = "/user/{userId}")
    public User getUserInfo(@PathVariable("userId") String userId) {
        User user = new User();
        user.setId(Long.valueOf(userId));
        return user;
    }

    public class User {

        @JsonProperty("user-name")
        private String userName;

        private Long id;

        private Integer age;

        @JsonIgnore
        private String address;

        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String memo;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        // get set 略

    }

}