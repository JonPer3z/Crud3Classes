package com.senai.atvd.Controller;


import com.senai.atvd.Entity.Produto;
import com.senai.atvd.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public


}
