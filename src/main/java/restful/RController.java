package restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright 2021 Charles Swires All Rights Reserved
 * @author charl
 *
 */
@RestController
@RequestMapping(path = "/control")
public class RController  {

    @Autowired
    private DecrypterService service;
   

    @GetMapping(path="/start", produces="application/json")
    public ResponseEntity<Boolean> start() {
        
        return new ResponseEntity<Boolean>(service.start(), HttpStatus.OK);
    }
    @GetMapping(path="/stop", produces="application/json")
    public ResponseEntity<Long> stop() {
        
        return new ResponseEntity<Long>(service.stop(), HttpStatus.OK);
    }
    @GetMapping(path="/verify", produces="application/json")
    public ResponseEntity<Boolean> verify() {
        
        return new ResponseEntity<Boolean>(service.verify(), HttpStatus.OK);
    }

}