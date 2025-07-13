package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.EstudianteReqDTO;
import com.appweb.nutrinet.dto.EstudianteResDTO;
import com.appweb.nutrinet.entity.Curso;
import com.appweb.nutrinet.entity.Estudiante;
import com.appweb.nutrinet.entity.Usuario;
import com.appweb.nutrinet.repository.CursoRepository;
import com.appweb.nutrinet.repository.EstudianteRepository;
import com.appweb.nutrinet.repository.UsuarioRepository;
import com.appweb.nutrinet.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository,
                                 CursoRepository cursoRepository,
                                 UsuarioRepository usuarioRepository) {
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private Estudiante fromRequest(EstudianteReqDTO dto) {
        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Usuario padre = usuarioRepository.findById(dto.getIdPadre())
                .orElseThrow(() -> new RuntimeException("Padre no encontrado"));

        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(dto.getNombres());
        estudiante.setApellidos(dto.getApellidos());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setAlergias(dto.getAlergias());
        estudiante.setCurso(curso);
        estudiante.setPadre(padre);

        return estudiante;
    }

    private EstudianteResDTO toResponse(Estudiante e) {
        EstudianteResDTO dto = new EstudianteResDTO();
        dto.setId(e.getId());
        dto.setNombres(e.getNombres());
        dto.setApellidos(e.getApellidos());
        dto.setFechaNacimiento(e.getFechaNacimiento());
        dto.setAlergias(e.getAlergias());
        dto.setIdCurso(e.getCurso().getId());
        dto.setNombreCurso(e.getCurso().getNombre());
        dto.setIdPadre(e.getPadre().getId());
        dto.setNombrePadre(e.getPadre().getNombre() + " " + e.getPadre().getApellido());
        return dto;
    }

    @Override
    public EstudianteResDTO crear(EstudianteReqDTO dto) {
        Estudiante estudiante = fromRequest(dto);
        estudianteRepository.save(estudiante);
        return toResponse(estudiante);
    }

    @Override
    public EstudianteResDTO obtenerPorId(int id) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return toResponse(estudiante);
    }

    @Override
    public List<EstudianteResDTO> listar() {
        return estudianteRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EstudianteResDTO actualizar(int id, EstudianteReqDTO dto) {
        Estudiante estudiante = estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Usuario padre = usuarioRepository.findById(dto.getIdPadre())
                .orElseThrow(() -> new RuntimeException("Padre no encontrado"));

        estudiante.setNombres(dto.getNombres());
        estudiante.setApellidos(dto.getApellidos());
        estudiante.setFechaNacimiento(dto.getFechaNacimiento());
        estudiante.setAlergias(dto.getAlergias());
        estudiante.setCurso(curso);
        estudiante.setPadre(padre);

        estudianteRepository.save(estudiante);
        return toResponse(estudiante);
    }

    @Override
    public void eliminar(int id) {
        if (!estudianteRepository.existsById(id)) {
            throw new RuntimeException("Estudiante no encontrado");
        }
        estudianteRepository.deleteById(id);
    }
}
