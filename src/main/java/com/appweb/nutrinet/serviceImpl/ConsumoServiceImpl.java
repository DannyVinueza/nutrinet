package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.repository.ConsumoRepository;
import com.appweb.nutrinet.service.ConsumoService;
import org.springframework.stereotype.Service;

@Service
public class ConsumoServiceImpl implements ConsumoService {
    private final ConsumoRepository consumoRepository;

    public ConsumoServiceImpl(ConsumoRepository consumoRepository) {
        this.consumoRepository = consumoRepository;
    }
}
