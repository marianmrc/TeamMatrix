package com.matrix.controller;

import com.matrix.model.Centre;
import com.matrix.model.Vaccine;
import com.matrix.service.CentreService;
import com.matrix.service.VaccinationService;
import com.matrix.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/platforma")
public class VaccinationController {
    private final VaccinationService vaccinationService;
    private final VaccineService vaccineService;
    private final CentreService centreService;

    @Autowired
    public VaccinationController(VaccinationService vaccinationService,
                                 VaccineService vaccineService,
                                 CentreService centreService) {
        this.vaccinationService = vaccinationService;
        this.vaccineService = vaccineService;
        this.centreService = centreService;
    }


}