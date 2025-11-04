package br.com.conta_bancaria.conta_bancaria.controllers;

import br.com.conta_bancaria.conta_bancaria.dto.requests.cliente.*;
import br.com.conta_bancaria.conta_bancaria.dto.responses.ApiResponse;
import br.com.conta_bancaria.conta_bancaria.dto.responses.cliente.ClienteResponse;
import br.com.conta_bancaria.conta_bancaria.factorys.cliente.ClienteFactory;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ClienteResponse>>> listarTodos() {
        try {
            List<Cliente> clientes = service.listarTodos();
            List<ClienteResponse> responses = clientes.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
            return ResponseEntity.ok(ApiResponse.success("Clientes listados com sucesso", responses));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao listar clientes: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponse>> buscarPorId(@PathVariable Long id) {
        try {
            return service.buscarPorId(id)
                .map(cliente -> {
                    ClienteResponse response = convertToResponse(cliente);
                    return ResponseEntity.ok(ApiResponse.success("Cliente encontrado", response));
                })
                .orElse(ResponseEntity.badRequest()
                    .body(ApiResponse.error("Cliente não encontrado com id: " + id)));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao buscar cliente: " + e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteResponse>> salvar(@RequestBody CreateClienteRequest request) {
        try {
            Cliente cliente = ClienteFactory.fromRequest(request);
            Cliente novo = service.salvar(cliente);
            ClienteResponse response = convertToResponse(novo);
            return ResponseEntity.ok(ApiResponse.success("Cliente criado com sucesso", response));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao criar cliente: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ClienteResponse>> atualizar(@PathVariable Long id, @RequestBody UpdateClienteRequest request) {
        try {
            Cliente clienteAtualizado = ClienteFactory.fromUpdate(request);
            Cliente atualizado = service.atualizar(id, clienteAtualizado);
            ClienteResponse response = convertToResponse(atualizado);
            return ResponseEntity.ok(ApiResponse.success("Cliente atualizado com sucesso", response));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao atualizar cliente: " + e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletar(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.ok(ApiResponse.success("Cliente deletado com sucesso", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao deletar cliente: " + e.getMessage()));
        }
    }

    private ClienteResponse convertToResponse(Cliente cliente) {
        return new ClienteResponse(
            cliente.getId(),
            cliente.getNome(),
            cliente.getEndereco(),
            cliente.getTelefone(),
            cliente.getCpf(),
            cliente.getAgencia(),
            cliente.getCodigoBanco()
        );
    }
}