package br.com.conta_bancaria.conta_bancaria.controllers;

import br.com.conta_bancaria.conta_bancaria.dto.requests.cliente.CreateClienteRequest;
import br.com.conta_bancaria.conta_bancaria.dto.responses.ApiResponse;
import br.com.conta_bancaria.conta_bancaria.dto.responses.cliente.ClienteResponse;
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
            List<Cliente> cliente = service.listarTodos();
            List<ClienteResponse> responses = cliente.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
            
            return ResponseEntity.ok(ApiResponse.success("Clientes listados com sucesso", responses));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao listar contas: " + e.getMessage()));
        }
    }

    /**
     * Método auxiliar para converter Entidade para Response DTO
     */
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

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ClienteResponse>> criarBanco(@RequestBody CreateClienteRequest request) 
    {
        try {
            Cliente cliente = new Cliente(
                request.getNome(),
                request.getEndereco(),
                request.getTelefone(),
                request.getCpf(),
                request.getAgencia(),
                request.getCodigoBanco()
            );

            Cliente clienteSalvo = service.salvar(cliente);

            ClienteResponse response = new ClienteResponse(
                clienteSalvo.getId(),
                clienteSalvo.getNome(),
                clienteSalvo.getEndereco(),
                clienteSalvo.getTelefone(),
                clienteSalvo.getCpf(),
                clienteSalvo.getAgencia(),
                clienteSalvo.getCodigoBanco()
            );

            return ResponseEntity.ok(ApiResponse.success("Cliente criado com sucesso", response));

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Erro ao criar cliente: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            Cliente atualizado = service.atualizar(id, cliente);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
