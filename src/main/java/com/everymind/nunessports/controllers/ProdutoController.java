package com.everymind.nunessports.controllers;

import com.everymind.nunessports.entities.Produto;
import com.everymind.nunessports.services.ProdutoService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/produtos")
    public String create(@ModelAttribute("produto") Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/api/v1/produtos";
    }

    @GetMapping("/produtos")
    public ModelAndView produtos() {
        ModelAndView mv = new ModelAndView("produtos");
        mv.addObject("produtos", produtoService.buscarTodos());
        mv.addObject("produto", new Produto());
        return mv;
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