package com.senai.atvd.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produto;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    private Integer idVenda;
    private LocalDate dataDeVenda;
}
