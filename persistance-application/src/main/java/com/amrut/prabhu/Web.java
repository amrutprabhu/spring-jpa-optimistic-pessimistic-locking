package com.amrut.prabhu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Web {


    @Autowired
    private CalculationsService calculationsService;

    @PostMapping("/{value}")
    public ResponseEntity calculate(@PathVariable(name = "value") BigDecimal value) throws InterruptedException {

        return ResponseEntity.ok(calculationsService.calculate(value));
    }
}
