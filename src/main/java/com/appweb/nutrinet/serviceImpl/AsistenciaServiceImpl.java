package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.repository.AsistenciaRepository;
import com.appweb.nutrinet.service.AsistenciaService;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
    private final AsistenciaRepository asistenciaRepository;

    public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }
}
