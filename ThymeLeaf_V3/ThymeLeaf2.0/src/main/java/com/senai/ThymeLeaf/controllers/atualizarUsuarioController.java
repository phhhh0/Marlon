package com.senai.ThymeLeaf.controllers;

import com.senai.ThymeLeaf.dtos.UsuarioDto;
import com.senai.ThymeLeaf.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizarusuario")
public class atualizarUsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/{id}")
    public String atualizarUsuario(Model model, @PathVariable Long id){               
        
        UsuarioDto usuario = usuarioService.obterUsuario(id);
                
        model.addAttribute("usuarioDto", usuario);
        
        if (usuario.getId() > 0){
            return "atualizarusuario";
        }
        
        return "redirect:/listausuarios";
    }

}

