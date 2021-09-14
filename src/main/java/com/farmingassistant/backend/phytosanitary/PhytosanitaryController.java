package com.farmingassistant.backend.phytosanitary;



import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping (path = "/phytosanitary")
public class PhytosanitaryController {

    private PhytosanitaryService phytosanitaryService;

    @Autowired
    private PhytosanitaryController (PhytosanitaryService phytosanitaryService) {
        this.phytosanitaryService = phytosanitaryService;
    }

    @GetMapping(path = "{insee}")
    public List<Phytosanitary> getPhytosanitary(@PathVariable ("insee") String insee) throws IOException, InterruptedException, ParseException {
        return phytosanitaryService.getPhytosanitary(insee);
    }
}
