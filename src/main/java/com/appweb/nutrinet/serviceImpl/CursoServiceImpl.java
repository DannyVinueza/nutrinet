package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.repository.CursoRepository;
import com.appweb.nutrinet.service.CursoService;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }
}
