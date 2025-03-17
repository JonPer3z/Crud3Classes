package com.senai.atvd.Controller;


import com.senai.atvd.Entity.Produto;
import com.senai.atvd.Repository.ProdutoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerProduto {

    @Autowired
    private ProdutoRepository ProdRepository;

    @PostMapping("/Produto/add")
    public ResponseEntity<Boolean> adicionarProduto(@RequestBody Produto p) {
        ProdRepository.save(p);

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
    @GetMapping("/Produto/get{id}")
    public List<Produto> getProfessor(){
        return ProdRepository.findAll();
    }

    @PutMapping("/Produto/atualizar/{id}")
    public ResponseEntity<Boolean> atualizarProfessor(@PathVariable Integer id, @RequestBody Produto p) {
        if (!ProdRepository.existsById(id)) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }

        p.setIdProduto(id);
        ProdRepository.save(p);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @DeleteMapping("/Produto/deletar{id}")
    public void deletarProduto (@PathVariable Integer id) {
        ProdRepository.deleteById(id);

    }


}
