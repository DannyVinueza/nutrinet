package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.repository.EstudianteRepository;
import com.appweb.nutrinet.service.EstudianteService;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }
}
