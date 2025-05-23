package br.unifor.bancodedado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unifor.bancodedado.model.Usuario;
import br.unifor.bancodedado.DTO.UsuarioDTO;
import br.unifor.bancodedado.Service.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.salvar(dto));
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }
}