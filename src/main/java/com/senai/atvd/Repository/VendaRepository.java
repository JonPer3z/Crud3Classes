package com.senai.atvd.Repository;

import com.senai.atvd.Entity.Produto;
import com.senai.atvd.Entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
