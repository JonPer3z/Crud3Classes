package com.senai.atvd.Controller;

import com.senai.atvd.Entity.Venda;
import com.senai.atvd.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class VendaController {

    @RestController
    @RequestMapping("/Venda")
    public class ControllerVenda {

        @Autowired
        private VendaRepository vendaRepository;

        // Adicionar uma venda
        @PostMapping("/add")
        public ResponseEntity<Boolean> adicionarVenda(@RequestBody Venda venda) {
            vendaRepository.save(venda);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }

        // Obter todas as vendas
        @GetMapping("/getAll")
        public List<Venda> getTodasVendas() {
            return vendaRepository.findAll();
        }

        // Obter uma venda por ID
        @GetMapping("/get/{id}")
        public ResponseEntity<Venda> getVenda(@PathVariable Integer id) {
            if (!vendaRepository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Venda venda = vendaRepository.findById(id).orElse(null);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        }

        // Atualizar uma venda existente
        @PutMapping("/atualizar/{id}")
        public ResponseEntity<Boolean> atualizarVenda(@PathVariable Integer id, @RequestBody Venda venda) {
            if (!vendaRepository.existsById(id)) {
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
            }

            venda.setIdVenda(id);
            vendaRepository.save(venda);

            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        // Deletar uma venda por ID
        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<Void> deletarVenda(@PathVariable Integer id) {
            if (!vendaRepository.existsById(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            vendaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
