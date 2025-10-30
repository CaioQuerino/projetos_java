package br.com.conta_bancaria.conta_bancaria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.conta_bancaria.conta_bancaria.dto.requests.conta.CreateContaRequest;
import br.com.conta_bancaria.conta_bancaria.dto.responses.ApiResponse;
import br.com.conta_bancaria.conta_bancaria.dto.responses.conta.ContaResponse;
import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.services.ContaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ContaResponse>> criarConta(@RequestBody CreateContaRequest request) {
        try {
            Conta conta = contaService.criarConta(
                request.getTipoConta(),
                request.getSaldo(),
                request.getClienteId(),
                request.getBancoId(),
                request.getSenha()
            );

            ContaResponse response = convertToResponse(conta);
            return ResponseEntity.ok(ApiResponse.success("Conta criada com sucesso", response));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao criar conta: " + e.getMessage()));
        }
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ApiResponse<ContaResponse>> buscarConta(@PathVariable String numeroConta) {
        try {
            Conta conta = contaService.buscarPorNumero(numeroConta);
            ContaResponse response = convertToResponse(conta);
            return ResponseEntity.ok(ApiResponse.success("Conta encontrada", response));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Conta não encontrada: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ContaResponse>>> listarTodasContas() {
        try {
            List<Conta> contas = contaService.listarTodas();
            List<ContaResponse> responses = contas.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
            
            return ResponseEntity.ok(ApiResponse.success("Contas listadas com sucesso", responses));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao listar contas: " + e.getMessage()));
        }
    }

    /**
     * Método auxiliar para converter Entidade para Response DTO
     */
    private ContaResponse convertToResponse(Conta conta) {
        return new ContaResponse(
            conta.getBanco().getAgencia(),
            conta.getNumeroConta(),
            conta.getTipoConta(),
            conta.getSaldo(),
            conta.getCliente().getNome(),
            conta.getBanco().getNome()
        );
    }
}