package com.everymind.nunessports.services;

import com.everymind.nunessports.entities.Produto;
import com.everymind.nunessports.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    // função para salvar produto
    @Transactional
    public Produto salvarProduto(Produto produto) {
        try {
            return produtoRepository.save(produto);
        } catch (DataIntegrityViolationException e) {
            // Adicione tratamento específico para a violação de integridade (por exemplo, produto já existente)
            throw new RuntimeException("Erro ao salvar o produto.", e);
        } catch (Exception e) {
            // Trate outras exceções genéricas
            throw new RuntimeException("Erro ao salvar o produto", e);
        }
    }

    // função para achar por id
    @Transactional(readOnly = true)
    public Optional<Produto> buscarPorId(Long id) {
        try {
            return produtoRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar o produto por ID", e);
        }
    }

    // função para achar todos
    @Transactional(readOnly = true)
    public List<Produto> buscarTodos() {
        try {
            return produtoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos os produtos", e);
        }
    }

    // função para deletar por id
    @Transactional
    public void deletarPorId(Long id) {
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            String mensagemErro = "Erro ao deletar o produto por ID";
            throw new RuntimeException(mensagemErro, e);
        }
    }


    // função para editar por id
    @Transactional
    public Produto editarPorId(Long id, Produto produtoAtualizado) {
        try {
            Optional<Produto> optionalProduto = produtoRepository.findById(id);

            if (optionalProduto.isPresent()) {
                Produto produtoExistente = optionalProduto.get();

                // atualiza os campos do produto existente com os valores do produto atualizado
                produtoExistente.setNome(produtoAtualizado.getNome());
                produtoExistente.setDescricao(produtoAtualizado.getDescricao());
                produtoExistente.setPreco(produtoAtualizado.getPreco());

                return produtoRepository.save(produtoExistente);
            } else {
                throw new RuntimeException("Produto não encontrado para o ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao editar o produto por ID", e);
        }
    }
}