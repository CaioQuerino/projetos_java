package br.com.conta_bancaria.conta_bancaria.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.services.BancoService;
import br.com.conta_bancaria.conta_bancaria.builders.BancoBuilder;
import br.com.conta_bancaria.conta_bancaria.dto.requests.banco.CreateBancoRequest;
import br.com.conta_bancaria.conta_bancaria.dto.requests.banco.UpdateBancoRequest;
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
                .body(ApiResponse.error("Erro ao listar bancos: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BancoResponse>> buscarPorId(@PathVariable Long id) {
        try {
            Optional<Banco> banco = bancoService.buscarPorId(id);
            if (banco.isPresent()) {
                BancoResponse response = convertToResponse(banco.get());
                return ResponseEntity.ok(ApiResponse.success("Banco encontrado", response));
            } else {
                return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Banco não encontrado com id: " + id));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao buscar banco: " + e.getMessage()));
        }
    }

    @GetMapping("/codigo/{codigoBanco}")
    public ResponseEntity<ApiResponse<BancoResponse>> buscarPorCodigo(@PathVariable String codigoBanco) {
        try {
            Optional<Banco> banco = bancoService.buscarPorCodigoBanco(codigoBanco);
            if (banco.isPresent()) {
                BancoResponse response = convertToResponse(banco.get());
                return ResponseEntity.ok(ApiResponse.success("Banco encontrado", response));
            } else {
                return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Banco não encontrado com código: " + codigoBanco));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao buscar banco: " + e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BancoResponse>> criarBanco(@RequestBody CreateBancoRequest request) {
        try {
            Banco banco = new BancoBuilder()
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .telefone(request.getTelefone())
                .cnpj(request.getCnpj())
                .agencia(request.getAgencia())
                .codigoBanco(request.getCodigoBanco())
                .build();
            
            Banco bancoSalvo = bancoService.salvar(banco);
            BancoResponse response = convertToResponse(bancoSalvo);
            return ResponseEntity.ok(ApiResponse.success("Banco criado com sucesso", response));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao criar banco: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BancoResponse>> atualizarBanco(@PathVariable Long id, @RequestBody UpdateBancoRequest request) {
        try {
            Banco bancoAtualizado = new BancoBuilder()
                .nome(request.getNome())
                .endereco(request.getEndereco())
                .telefone(request.getTelefone())
                .cnpj(request.getCnpj())
                .agencia(request.getAgencia())
                .codigoBanco(request.getCodigoBanco())
                .build();
            
            Banco banco = bancoService.atualizar(id, bancoAtualizado);
            BancoResponse response = convertToResponse(banco);
            return ResponseEntity.ok(ApiResponse.success("Banco atualizado com sucesso", response));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao atualizar banco: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletarBanco(@PathVariable Long id) {
        try {
            bancoService.deletar(id);
            return ResponseEntity.ok(ApiResponse.success("Banco deletado com sucesso", null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao deletar banco: " + e.getMessage()));
        }
    }

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
}