package com.senai.login.services;

import com.senai.login.dtos.ClienteDto;
import com.senai.login.models.ClienteModel;
import com.senai.login.repositories.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repositorio;

    public boolean autenticarCliente(ClienteDto email) {

        Optional<ClienteModel> optionalCliente = obterClientePorEmail(email.getEmail());

        if (optionalCliente.isPresent()) {
            if (optionalCliente.get().getEmail().equals(email.getEmail())) {
                //--Senha correta, retorna verdadeiro
                return true;
            }
        }
        //--Não encontrou o usuário ou a senha esta incorreta!
        return false;
    }
    
     public boolean cadastrarCliente(ClienteDto cadastro){
         ClienteModel cliente = new ClienteModel();
        
        //--Atribui valores vindos da requisição para o objeto model
        cliente.setCodigo(cadastro.getCodigo());
        cliente.setNome(cadastro.getNome());
        cliente.setEmail(cadastro.getEmail());
        cliente.setTelefone(cadastro.getTelefone());
        cliente.setDataDeCadastro(cadastro.getDataDeCadastro());
        cliente.setEndereco(cadastro.getEndereco());
        cliente.setNumeroEndereco(cadastro.getNumeroEndereco());
       
        
        //--Realiza a gravação no banco de dados
        repositorio.save(cliente);
        
        //--Retorna true
        return true;
        
    }
     
      public boolean atualizarUsuario(ClienteDto cadastro, String email){
    
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin"; 
       Optional<ClienteModel> optionalCliente = obterClientePorEmail(email);

       if (!optionalCliente.isPresent()){
           return false;
       }
       
        ClienteModel cliente = optionalCliente.get();
        cliente.setNome(cadastro.getNome());
        cliente.setEmail(cadastro.getEmail());
        cliente.setTelefone(cadastro.getTelefone());
        cliente.setDataDeCadastro(cadastro.getDataDeCadastro());
        cliente.setEndereco(cadastro.getEndereco());
        cliente.setNumeroEndereco(cadastro.getNumeroEndereco());
        
        repositorio.save(cliente);
        
        return true;
    }  
      
      public boolean excluirCliente(Long codigo){
        
        Optional<ClienteModel> optionalCliente = repositorio.findById(codigo);
        
        if (optionalCliente.isPresent()){
            repositorio.deleteById(codigo);        
            return true;
        }      
                
        return false;
    }
      
       public List<ClienteModel> obterClientes(){
        
        List<ClienteModel> lista = repositorio.findAll();
        
        return lista;
        
    }
       
       private Optional<ClienteModel> obterClientePorEmail(String email){
        
        //--busca usuário no repositorio (banco de dados) por login
        //-- Aqui será realizado o "select * from usuario where usuario_login = "admin"; 
        Optional<ClienteModel> optionalCliente = repositorio.findByEmail(email);
     
        return optionalCliente;
    }
     
   
}