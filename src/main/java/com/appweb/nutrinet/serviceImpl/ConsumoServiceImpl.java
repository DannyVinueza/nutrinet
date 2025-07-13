package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.ConsumoReqDTO;
import com.appweb.nutrinet.dto.ConsumoResDTO;
import com.appweb.nutrinet.entity.Consumo;
import com.appweb.nutrinet.entity.Estudiante;
import com.appweb.nutrinet.entity.Menu;
import com.appweb.nutrinet.repository.ConsumoRepository;
import com.appweb.nutrinet.repository.EstudianteRepository;
import com.appweb.nutrinet.repository.MenuRepository;
import com.appweb.nutrinet.service.ConsumoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumoServiceImpl implements ConsumoService {

    private final ConsumoRepository consumoRepository;
    private final EstudianteRepository estudianteRepository;
    private final MenuRepository menuRepository;

    public ConsumoServiceImpl(ConsumoRepository consumoRepository,
                              EstudianteRepository estudianteRepository,
                              MenuRepository menuRepository) {
        this.consumoRepository = consumoRepository;
        this.estudianteRepository = estudianteRepository;
        this.menuRepository = menuRepository;
    }

    private Consumo fromRequest(ConsumoReqDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Menu menu = menuRepository.findById(dto.getIdMenu())
                .orElseThrow(() -> new RuntimeException("Menú no encontrado"));

        Consumo consumo = new Consumo();
        consumo.setEstudiante(estudiante);
        consumo.setMenu(menu);
        consumo.setTipoComida(dto.getTipoComida());
        consumo.setCompleto(dto.getCompleto() != null ? dto.getCompleto() : false);
        consumo.setObservaciones(dto.getObservaciones());

        return consumo;
    }

    private ConsumoResDTO toResponse(Consumo c) {
        ConsumoResDTO dto = new ConsumoResDTO();
        dto.setId(c.getId());
        dto.setIdMenu(c.getMenu().getIdMenu());
        dto.setIdEstudiante(c.getEstudiante().getId());
        dto.setNombreEstudiante(c.getEstudiante().getNombres()); 
        dto.setFecha(c.getFecha());
        dto.setTipoComida(c.getTipoComida());
        dto.setCompleto(c.getCompleto());
        dto.setObservaciones(c.getObservaciones());
        return dto;
    }

    @Override
    public ConsumoResDTO crear(ConsumoReqDTO dto) {
        Consumo consumo = fromRequest(dto);
        consumoRepository.save(consumo);
        return toResponse(consumo);
    }

    @Override
    public ConsumoResDTO obtenerPorId(int id) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));
        return toResponse(consumo);
    }

    @Override
    public List<ConsumoResDTO> listar() {
        return consumoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ConsumoResDTO actualizar(int id, ConsumoReqDTO dto) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consumo no encontrado"));

        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Menu menu = menuRepository.findById(dto.getIdMenu())
                .orElseThrow(() -> new RuntimeException("Menú no encontrado"));

        consumo.setEstudiante(estudiante);
        consumo.setMenu(menu);
        consumo.setTipoComida(dto.getTipoComida());
        consumo.setCompleto(dto.getCompleto());
        consumo.setObservaciones(dto.getObservaciones());

        consumoRepository.save(consumo);
        return toResponse(consumo);
    }

    @Override
    public void eliminar(int id) {
        if (!consumoRepository.existsById(id)) {
            throw new RuntimeException("Consumo no encontrado");
        }
        consumoRepository.deleteById(id);
    }
}
