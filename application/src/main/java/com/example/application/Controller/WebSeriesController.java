package com.example.application.Controller;

import com.example.application.Model.WebSeries;
import com.example.application.Repository.WebSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebSeriesController {

    @Autowired
    private WebSeriesRepository repository;

    @PostMapping("/addSeries")
    public void store_webseries(@RequestBody WebSeries details) {
        WebSeries webseries = new WebSeries();
        webseries.setId(details.getId());
        webseries.setName(details.getName());
        webseries.setSeasons(details.getSeasons());
        webseries.setEpisodes(details.getEpisodes());
        webseries.setRating(details.getRating());

        repository.save(webseries);
    }

    @GetMapping("/series")
    public List<WebSeries> get_webseries() {
        return repository.findAll();
    }

    @GetMapping("/series/id/{id}")
    public WebSeries get_webseriesbyid(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @GetMapping("/series/name/{name}")
    public List<WebSeries> get_webseriesbyname(@PathVariable String name) {
        return repository.findByName(name);
    }

    @PutMapping("/update")
    public void update_webseries(@RequestBody WebSeries details) {
        WebSeries webseries = repository.getOne(details.getId());

        webseries.setName(details.getName());
        webseries.setSeasons(details.getSeasons());
        webseries.setEpisodes(details.getEpisodes());
        webseries.setRating(details.getRating());

        repository.save(webseries);
    }

    @DeleteMapping("/delete/{id}")
    public String delete_webseries(@PathVariable int id) {
        repository.deleteById(id);
        return "Series Removed!" + id;
    }
}
