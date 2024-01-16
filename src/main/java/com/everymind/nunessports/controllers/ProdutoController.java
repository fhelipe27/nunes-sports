package com.everymind.nunessports.controllers;

import com.everymind.nunessports.entities.Produto;
import com.everymind.nunessports.services.ProdutoService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProdutoController {

    @Autowired
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

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("editar");
        Optional<Produto> produtoFind = produtoService.buscarPorId(id);
        Produto produto = produtoFind.orElse(null); // Extrai o objeto Produto do Optional
        mv.addObject("produto", produto);
        return mv;
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable("id") Long id) {
        produtoService.deletarPorId(id);
        return "redirect:/api/v1/produtos";
    }


}