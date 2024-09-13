package com.senai.controleestoque.controllers;

import com.senai.controleestoque.dtos.*;
import com.senai.controleestoque.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/criar")
    public ResponseEntity<ResultadoDTO> createProduto(@RequestBody ProdutoDTO dados) {
        
        boolean retorno = produtoService.criarProdutos(dados);
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
}
