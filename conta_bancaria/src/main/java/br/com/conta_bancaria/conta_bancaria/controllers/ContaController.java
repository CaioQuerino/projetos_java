package br.com.conta_bancaria.conta_bancaria.controllers;

import org.springframework.web.bind.annotation.*;
import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.models.Banco;
import br.com.conta_bancaria.conta_bancaria.models.Cliente;
import br.com.conta_bancaria.conta_bancaria.services.ContaService;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping
    public Conta criarConta(@RequestBody Conta conta) {
        return this.contaService.criarConta(
            conta.getNumeroConta(),
            conta.getTipoConta(),
            conta.getSaldo(),
            conta.getCliente(),
            conta.getBanco(),
            conta.getSenha()
        );
    }

    @GetMapping("/{numeroConta}")
    public Conta buscarConta(@PathVariable String numeroConta) {
        return contaService.buscarPorNumero(numeroConta);
    }

    @GetMapping
    public List<Conta> listarTodasContas() {
        return contaService.listarTodas();
    }

    @GetMapping("/bancos")
    public List<Banco> listarTodosBancos() {
        return contaService.listarTodosBancos();
    }

    @GetMapping("/clientes")
    public List<Cliente> listarTodosClientes() {
        return contaService.listarTodosClientes();
    }
}