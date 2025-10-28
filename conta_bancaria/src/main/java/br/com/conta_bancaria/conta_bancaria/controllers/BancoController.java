package br.com.conta_bancaria.conta_bancaria.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.services.BancoService;
import br.com.conta_bancaria.conta_bancaria.dto.requests.banco.CreateBancoRequest;
import br.com.conta_bancaria.conta_bancaria.dto.responses.ApiResponse;
import br.com.conta_bancaria.conta_bancaria.dto.responses.banco.BancoResponse;

@RestController
@RequestMapping("/bancos")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BancoResponse>>> listarTodos() {
        try {
            List<Banco> banco = bancoService.listarTodos();
            List<BancoResponse> responses = banco.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
            
            return ResponseEntity.ok(ApiResponse.success("Bancos listados com sucesso", responses));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao listar contas: " + e.getMessage()));
        }
    }

    /**
     * Método auxiliar para converter Entidade para Response DTO
     */
    private BancoResponse convertToResponse(Banco banco) {
        return new BancoResponse(
            banco.getId(),
            banco.getNome(),
            banco.getEndereco(),
            banco.getTelefone(),
            banco.getCnpj(),
            banco.getAgencia(),
            banco.getCodigoBanco()
        );
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
public ResponseEntity<ApiResponse<BancoResponse>> criarBanco(@RequestBody CreateBancoRequest request) 
{
    try {
        // Converter request para entidade
        Banco banco = new Banco(
            request.getNome(),
            request.getEndereco(),
            request.getTelefone(),
            request.getCnpj(),
            request.getAgencia(),
            request.getCodigoBanco()
        );
        
        Banco bancoSalvo = bancoService.salvar(banco);
        
        // Converter entidade para response
        BancoResponse response = new BancoResponse(
            bancoSalvo.getId(),
            bancoSalvo.getNome(),
            bancoSalvo.getEndereco(),
            bancoSalvo.getTelefone(),
            bancoSalvo.getCnpj(),
            bancoSalvo.getAgencia(),
            bancoSalvo.getCodigoBanco()
        );
        
        return ResponseEntity.ok(ApiResponse.success("Banco criado com sucesso", response));
        
    } catch (Exception e) {
        return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao criar banco: " + e.getMessage()));
    }
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