package com.matrix.controller;

import com.matrix.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/platforma")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService) {
        this.vaccinationService = vaccinationService;
    }

    @RequestMapping({"/vaccination"})
    public String getVaccinationPage() {
        return "vaccination";
    }
}