package com.senai.controleestoque.services;

import com.senai.controleestoque.dtos.*;
import com.senai.controleestoque.models.EstoqueModel;
import java.util.ArrayList;
import java.util.Objects;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    ArrayList<EstoqueModel> listaEstoque = new ArrayList<EstoqueModel>();

    public boolean criarEstoque(ControleDTO dados) {

        EstoqueModel estoque = new EstoqueModel();

        for(var item : listaEstoque){
            if(Objects.equals(item.getId(), dados.getId())){
                
                return false;
            }
        }
        
        int quantidade = dados.getQuantidade();
        Long id = dados.getId();
        Long produto = dados.getIdProduto();

        estoque.setQuantidade(quantidade);
        estoque.setId(id);
        estoque.setIdProduto(produto);

        listaEstoque.add(estoque);

        return true;
    }

}
