package ru.litvinov.springsecurity100500.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.litvinov.springsecurity100500.model.Developer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private List<Developer> developers = Stream.of(
            new Developer(1L,"Ivan","Ivanov"),
            new Developer(2L,"Dim","Dimich"),
            new Developer(3L,"Petr","Petrov")
    ).collect(Collectors.toList());

    @RequestMapping(method = RequestMethod.GET)
    public List<Developer> getAll(){
        return developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return developers.stream().filter(developer -> developer.getId().equals(id)).findFirst().orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer) {
        System.out.println(developer);
        developers.add(developer);
        return developer;
    }
}
