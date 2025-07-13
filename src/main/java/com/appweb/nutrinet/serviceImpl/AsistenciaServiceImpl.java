package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.AsistenciaReqDTO;
import com.appweb.nutrinet.dto.AsistenciaResDTO;
import com.appweb.nutrinet.entity.Asistencia;
import com.appweb.nutrinet.entity.Estudiante;
import com.appweb.nutrinet.repository.AsistenciaRepository;
import com.appweb.nutrinet.repository.EstudianteRepository;
import com.appweb.nutrinet.service.AsistenciaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final EstudianteRepository estudianteRepository;

    public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository, EstudianteRepository estudianteRepository) {
        this.asistenciaRepository = asistenciaRepository;
        this.estudianteRepository = estudianteRepository;
    }

    private Asistencia fromRequest(AsistenciaReqDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(dto.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(estudiante);
        asistencia.setFecha(dto.getFecha());
        asistencia.setPresente(dto.getPresente());
        asistencia.setObservaciones(dto.getObservaciones());
        return asistencia;
    }

    private AsistenciaResDTO toResponse(Asistencia asistencia) {
        AsistenciaResDTO dto = new AsistenciaResDTO();
        dto.setId(asistencia.getId());
        dto.setIdEstudiante(asistencia.getEstudiante().getId());
        dto.setNombreEstudiante(asistencia.getEstudiante().getNombres()); 
        dto.setFecha(asistencia.getFecha());
        dto.setPresente(asistencia.getPresente());
        dto.setObservaciones(asistencia.getObservaciones());
        return dto;
    }

    @Override
    public AsistenciaResDTO crear(AsistenciaReqDTO asistenciaDTO) {
        Asistencia asistencia = fromRequest(asistenciaDTO);
        asistenciaRepository.save(asistencia);
        return toResponse(asistencia);
    }

    @Override
    public AsistenciaResDTO obtenerPorId(int id) {
        Asistencia asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
        return toResponse(asistencia);
    }

    @Override
    public List<AsistenciaResDTO> listar() {
        return asistenciaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AsistenciaResDTO actualizar(int id, AsistenciaReqDTO asistenciaDTO) {
        Asistencia asistencia = asistenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));

        Estudiante estudiante = estudianteRepository.findById(asistenciaDTO.getIdEstudiante())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        asistencia.setEstudiante(estudiante);
        asistencia.setFecha(asistenciaDTO.getFecha());
        asistencia.setPresente(asistenciaDTO.getPresente());
        asistencia.setObservaciones(asistenciaDTO.getObservaciones());

        asistenciaRepository.save(asistencia);
        return toResponse(asistencia);
    }

    @Override
    public void eliminar(int id) {
        if (!asistenciaRepository.existsById(id)) {
            throw new RuntimeException("Asistencia no encontrada");
        }
        asistenciaRepository.deleteById(id);
    }
}
