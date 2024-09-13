package com.senai.controleestoque.controllers;

import com.senai.controleestoque.dtos.*;
import com.senai.controleestoque.models.*;
import com.senai.controleestoque.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
     EstoqueService estoqueService;

    @PostMapping("/criar") //asinatura de metodo
    public ResponseEntity<ResultadoDTO> createEstoque(@RequestBody ControleDTO dados) {
            
        boolean retorno = estoqueService.criarEstoque(dados);
        ResultadoDTO resposta = new ResultadoDTO();
        
        if(retorno){
            
         resposta.setMessage("Sucesso ao Criar");
         
        return ResponseEntity.ok().body(resposta);
        }
        else {
             resposta.setMessage("Erro ao Criar");
             return ResponseEntity.badRequest().body(resposta);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> getEstoque(@PathVariable Long id) {
        return ResponseEntity.ok().body(null);
    }
}
