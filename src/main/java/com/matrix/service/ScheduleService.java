package com.matrix.service;

import com.matrix.repository.ScheduleRepository;
import com.matrix.repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final VaccinationRepository vaccinationRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, VaccinationRepository vaccinationRepository) {
        this.scheduleRepository = scheduleRepository;
        this.vaccinationRepository = vaccinationRepository;
    }
}
