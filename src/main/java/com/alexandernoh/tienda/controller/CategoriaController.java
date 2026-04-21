package com.alexandernoh.tienda.controller;

import com.alexandernoh.tienda.entity.Categoria;
import com.alexandernoh.tienda.service.CategoriaService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("categoria", categoriaService.listar());
        return "categoria";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("modoEdicion", false);
        return "categoria-form";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable Integer id, Model model){
        Categoria categoria = categoriaService.buscarPorId(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("modoEdicion", true);
        return "categoria-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("modoEdicion", false);
            return "categoria-form";
        }
        categoriaService.crear(categoria);
        return "redirect:/categoria";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute("categoria") Categoria categoria, Model model){
        Categoria actualizado = categoriaService.actualizar(id, categoria);
        if(categoria != null){
            return "redirect:/categoria";
        } else {
            model.addAttribute("error", "No se pudo actualizar el usuario ");
            return "categoria-form";
        }
    }

    @GetMapping("/buscar")
    public String buscarPorId(@RequestParam(name = "idCategoria") Integer id, Model model){
        Categoria categoria = categoriaService.buscarPorId(id);
        if(categoria != null){
            model.addAttribute("categoriaEncontrado", categoria);
        } else {
            model.addAttribute("error", "Error categoria no encontrado: ");
        }
        return "categoria";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        categoriaService.eliminar(id);
        return "redirect:/categoria";
    }
}