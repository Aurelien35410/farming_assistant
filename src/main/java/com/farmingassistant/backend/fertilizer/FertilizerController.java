package com.farmingassistant.backend.fertilizer;


import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "/fertilizer")
public class FertilizerController {

    private FertilizerService fertilizerService;

    @Autowired
    private FertilizerController (FertilizerService fertilizerService) {
        this.fertilizerService = fertilizerService;
    }

    @GetMapping(path = "{insee}")
    public List<Fertilizer> getFertilizer(@PathVariable ("insee") String insee) throws IOException, ParseException, InterruptedException {
        return fertilizerService.getFertilizer(insee);
    }




}
