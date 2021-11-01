package com.matrix.controller;

import com.matrix.service.CentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CentreController {
    private CentreService centreService;

    @Autowired
    public CentreController(CentreService centreService) {
        this.centreService = centreService;
    }
}
