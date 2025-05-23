package br.unifor.bancodedado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unifor.bancodedado.model.Atividade;
import br.unifor.bancodedado.DTO.AtividadeDTO;
import br.unifor.bancodedado.Service.AtividadeService;

import java.util.List;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping
    public ResponseEntity<Atividade> criar(@RequestBody AtividadeDTO dto) {
        return ResponseEntity.ok(atividadeService.salvar(dto));
    }

    @GetMapping
    public List<Atividade> listar() {
        return atividadeService.listarTodas();
    }
}
