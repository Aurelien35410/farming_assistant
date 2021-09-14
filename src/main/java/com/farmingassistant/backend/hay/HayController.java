package com.farmingassistant.backend.hay;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "/hay")
public class HayController {

    private HayService hayService;

    @Autowired
    private HayController (HayService hayService) {
        this.hayService = hayService;
    }

    @GetMapping(path = "{insee}")
    public List<com.example.demo.hay.Hay> getHay(@PathVariable ("insee") String insee) throws IOException, ParseException, InterruptedException {
        return hayService.getHay(insee);
    }
}
