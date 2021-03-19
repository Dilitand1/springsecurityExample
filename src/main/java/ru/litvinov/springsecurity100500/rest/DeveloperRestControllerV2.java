package ru.litvinov.springsecurity100500.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v2/developers")
public class DeveloperRestControllerV2 {

    @GetMapping
    public List<String> getAllUsers(){
        return new ArrayList<>(Arrays.asList(new String[]{"a","b","c"}));
    }

}
