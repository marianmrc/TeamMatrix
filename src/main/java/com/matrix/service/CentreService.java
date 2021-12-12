package com.matrix.service;

import com.matrix.repository.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreService {
    private final CentreRepository centreRepository;

    @Autowired
    public CentreService(CentreRepository centreRepository) {
        this.centreRepository = centreRepository;
    }
}
