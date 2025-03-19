package com.senai.atvd.Controller;

import com.senai.atvd.Entity.Cliente;
import com.senai.atvd.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ControllerCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    // Adicionar um cliente
    @PostMapping("/add")
    public ResponseEntity<Boolean> adicionarCliente(@RequestBody Cliente cliente) {
        if (cliente.getNome() == null || cliente.getTelefone() == null) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST); // Retorna erro 400 se faltarem campos obrigatórios
        }
        clienteRepository.save(cliente);
        return new ResponseEntity<>(true, HttpStatus.CREATED); // Retorna 201 (Created) se a operação for bem-sucedida
    }

    // Obter todos os clientes
    @GetMapping("/getAll")
    public ResponseEntity<List<Cliente>> getTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK); // Retorna a lista de clientes com status 200
    }

    // Obter um cliente por ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se o cliente não for encontrado
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    // Atualizar um cliente existente
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Boolean> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND); // Retorna 404 se o cliente não for encontrado
        }
        cliente.setIdCliente(id);  // Assume que o método setIdCliente existe
        clienteRepository.save(cliente);
        return new ResponseEntity<>(true, HttpStatus.OK); // Retorna 200 se a atualização for bem-sucedida
    }

    // Deletar um cliente por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 se o cliente não for encontrado
        }
        clienteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 após a exclusão bem-sucedida
    }
}
