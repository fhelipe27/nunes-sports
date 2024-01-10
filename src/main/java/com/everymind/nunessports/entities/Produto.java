package com.everymind.nunessports.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "produtos")
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "codigo", unique = true, nullable = false, length = 10)
    private String codigo;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "valor", columnDefinition = "decimal(7,2)")
    private BigDecimal preco;

}
