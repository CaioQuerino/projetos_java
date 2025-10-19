package br.com.conta_bancaria.conta_bancaria.controllers;

import org.springframework.web.bind.annotation.*;
import br.com.conta_bancaria.conta_bancaria.models.Conta;
import br.com.conta_bancaria.conta_bancaria.services.ContaService;

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
}
