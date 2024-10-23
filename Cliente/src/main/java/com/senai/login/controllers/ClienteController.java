package com.senai.login.controllers;

import com.senai.login.dtos.ClienteDto;
import com.senai.login.dtos.RespostaDto;
import com.senai.login.models.ClienteModel;
import com.senai.login.services.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public  ResponseEntity<RespostaDto> cadastrarCliente(@RequestBody ClienteDto cadastro){
        
        boolean retorno = clienteService.cadastrarCliente(cadastro);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Cadastro do cliente realizado com sucesso" : "Erro ao realizar cadastro do cliente ");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
        
    }
    
    @PutMapping("/cliente/{login}")
    public  ResponseEntity<RespostaDto> atualizarUsuario(@RequestBody ClienteDto cadastro, @PathVariable String email){
        
        boolean retorno = clienteService.atualizarUsuario(cadastro, email);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Atualização do cliente  realizado com sucesso" : "Erro ao realizar atualização do cliente");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }
    
    @DeleteMapping("/cliente/{codigo}")
    public ResponseEntity<RespostaDto> deletarCliente(@PathVariable Long codigo){
        
        boolean retorno = clienteService.excluirCliente(codigo);
        
        RespostaDto resposta = new RespostaDto();
        resposta.setMensagem(retorno ? "Delete do cliente realizado com sucesso" : "Erro ao realizar delete do cliente");
        
        return ResponseEntity.status(HttpStatus.OK).body(resposta); 
    }
    
     @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> obterClientes(){
        
        List<ClienteModel> lista = clienteService.obterClientes();
        
        return ResponseEntity.status(HttpStatus.OK).body(lista); 
        
    }
}