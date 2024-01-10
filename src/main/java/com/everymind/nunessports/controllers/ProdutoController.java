package com.everymind.nunessports.controllers;

import com.everymind.nunessports.entities.Produto;
import com.everymind.nunessports.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping
    public List<Produto> buscarTodos() {
        return produtoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto editarPorId(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return produtoService.editarPorId(id, produtoAtualizado);
    }

}