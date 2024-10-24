package com.senai.ThymeLeaf.services;

import com.senai.ThymeLeaf.dtos.CadastroContatoDto;
import com.senai.ThymeLeaf.dtos.ContatoDto;
import com.senai.ThymeLeaf.models.ContatoModel;
import com.senai.ThymeLeaf.repositories.ContatoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class ContatoService {
    
    @Autowired
    ContatoRepository repository;
            
    public List<ContatoDto> obterListaContatos(){
        
        List<ContatoModel> listaContatoModel = repository.findAll();
        
        List<ContatoDto> listaContato = new ArrayList<>();
        
        for (ContatoModel contato : listaContatoModel){
            
            ContatoDto contatodto = new ContatoDto();
            contatodto.setId(contato.getId() );
            contatodto.setNome(contato.getNome());
            contatodto.setEmail(contato.getEmail());
            contatodto.setEndereco(contato.getEndereco());
            contatodto.setCpf(contato.getCpf());
            contatodto.setDataCadastro(contato.getDataDeCadastro());
            
            listaContato.add(contatodto);
        }
        
        return listaContato;
        
    }
    
    public boolean cadastrarContato(CadastroContatoDto cadastro){
        
        Optional<ContatoModel> optionalUsuario = repository.findByEmail(cadastro.getEmail());
        
        if (optionalUsuario.isPresent()){
            return false;
        }
        
        ContatoModel contato = new ContatoModel();
        
        contato.setEmail(cadastro.getEmail());
        contato.setNome(cadastro.getNome());
        contato.setCpf(cadastro.getCpf());
        contato.setDataDeCadastro(LocalDate.now());
        contato.setEndereco(cadastro.getEndereco());
        contato.setTelefone(cadastro.getTelefone());
        
        repository.save(contato);
        
        return true;
    }
    
    public boolean excluirContato(Long id){
        
        System.out.println("id:" + id);
        
        Optional<ContatoModel> optionalUsuario = repository.findById(id);
        
        if (!optionalUsuario.isPresent()){
            return false;
        }
        
        repository.delete(optionalUsuario.get());
        
        return true;
        
    }
    
    public ContatoDto obterContato(Long id){
        
        Optional<ContatoModel> optionalContato = repository.findById(id);
        
        ContatoDto contatoDto = new ContatoDto();
        
        if (!optionalContato.isPresent()){            
            contatoDto.setId(0L);
            return contatoDto;
        }
        
        contatoDto.setId(optionalContato.get().getId());
        contatoDto.setEmail(optionalContato.get().getEmail()); 
        contatoDto.setCpf(optionalContato.get().getCpf());
        contatoDto.setEndereco(optionalContato.get().getEndereco());
        contatoDto.setNome(optionalContato.get().getNome());
        contatoDto.setDataCadastro(optionalContato.get().getDataDeCadastro());
        contatoDto.setTelefone(optionalContato.get().getTelefone());
        
        return contatoDto;
    }
    
    public boolean atualizarUsuario(Long id, ContatoDto dados){
        
         Optional<ContatoModel> optionalUsuario = repository.findById(id);
         
         if(!optionalUsuario.isPresent()){
             return false;
         }
         
         ContatoModel contato = new ContatoModel();
         contato.setEmail(dados.getEmail());
         contato.setCpf(dados.getCpf());
         contato.setNome(dados.getNome());
         contato.setTelefone(dados.getTelefone());
         contato.setEndereco(dados.getEndereco());
         contato.setDataDeCadastro(LocalDate.now());
         
         repository.save(contato);
                 
        return true;
    }
}

