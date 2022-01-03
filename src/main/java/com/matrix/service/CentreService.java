package com.matrix.service;

import com.matrix.model.Centre;
import com.matrix.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {
    private final CentreRepository centreRepository;

    @Autowired
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }

    public List<Centre> getCentres() {
        return centreRepository.findAll();
    }
}
