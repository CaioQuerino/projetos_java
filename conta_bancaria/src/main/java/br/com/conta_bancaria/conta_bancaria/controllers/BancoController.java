package br.com.conta_bancaria.conta_bancaria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.services.BancoService;

@RestController
@RequestMapping("/bancos")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping
    public List<Banco> listarTodos() {
        return bancoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banco> buscarPorId(@PathVariable Long id) {
        Optional<Banco> banco = bancoService.buscarPorId(id);
        return banco.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/codigo/{codigoBanco}")
    public ResponseEntity<Banco> buscarPorCodigo(@PathVariable String codigoBanco) {
        Optional<Banco> banco = bancoService.buscarPorCodigoBanco(codigoBanco);
        return banco.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Banco criarBanco(@RequestBody Banco banco) {
        return bancoService.salvar(banco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banco> atualizarBanco(@PathVariable Long id, @RequestBody Banco banco) {
        try {
            Banco bancoAtualizado = bancoService.atualizar(id, banco);
            return ResponseEntity.ok(bancoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBanco(@PathVariable Long id) {
        try {
            bancoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}