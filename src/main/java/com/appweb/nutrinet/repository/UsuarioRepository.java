package com.appweb.nutrinet.repository;

import com.appweb.nutrinet.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
