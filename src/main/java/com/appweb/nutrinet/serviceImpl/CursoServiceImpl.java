package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.CursoReqDTO;
import com.appweb.nutrinet.dto.CursoResDTO;
import com.appweb.nutrinet.entity.Curso;
import com.appweb.nutrinet.entity.Usuario;
import com.appweb.nutrinet.repository.CursoRepository;
import com.appweb.nutrinet.repository.UsuarioRepository;
import com.appweb.nutrinet.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public CursoServiceImpl(CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private Curso fromRequest(CursoReqDTO dto) {
        Usuario tutor = usuarioRepository.findById(dto.getIdTutor())
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setTutor(tutor);
        return curso;
    }

    private CursoResDTO toResponse(Curso curso) {
        CursoResDTO dto = new CursoResDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setIdTutor(curso.getTutor().getId());
        return dto;
    }

    @Override
    public CursoResDTO crear(CursoReqDTO dto) {
        Curso curso = fromRequest(dto);
        cursoRepository.save(curso);
        return toResponse(curso);
    }

    @Override
    public CursoResDTO obtenerPorId(int id) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        return toResponse(curso);
    }

    @Override
    public List<CursoResDTO> listar() {
        return cursoRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CursoResDTO actualizar(int id, CursoReqDTO dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Usuario tutor = usuarioRepository.findById(dto.getIdTutor())
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setTutor(tutor);

        cursoRepository.save(curso);
        return toResponse(curso);
    }

    @Override
    public void eliminar(int id) {
        if (!cursoRepository.existsById(id)) {
            throw new RuntimeException("Curso no encontrado");
        }
        cursoRepository.deleteById(id);
    }
}
