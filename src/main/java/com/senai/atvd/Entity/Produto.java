package com.senai.atvd.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    private Integer idProduto;
    private String nome;
    private String tipo;
    private Number preco;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Venda venda;

}
