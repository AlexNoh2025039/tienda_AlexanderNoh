package com.alexandernoh.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.alexandernoh.tienda.entity.DetallePedido;
import com.alexandernoh.tienda.service.DetalleService;

import jakarta.validation.Valid;

@Controller
@Validated
@RequestMapping("/detallePedido")
public class DetallePedidoController {
    
    private final DetalleService detalleService;

    public DetallePedidoController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("detalles", detalleService.listar());
        return "detallePedido";
    }


    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("detallePedido", new DetallePedido());
        model.addAttribute("modoEdicion", false);
        return "detallePedido-form";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable Integer id, Model model){
        DetallePedido detallePedido = detalleService.buscarPorId(id);
        if(detallePedido == null) {
            model.addAttribute("error", "Detalle no encontrado");
            return "redirect:/detallePedido";
        }
        model.addAttribute("detallePedido",detallePedido);
        model.addAttribute("modoEdicion", true);
        return "detallePedido-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("detallePedido") DetallePedido detallePedido, BindingResult result,Model model){
        if(result.hasErrors()) {
        model.addAttribute("modoEdicion", false);
        return "detallePedido-form";
        }
        detalleService.crear(detallePedido);
        return "redirect:/detallePedido";
    }

    @GetMapping("/buscar")
    public String buscarPorId(@RequestParam(name = "idDetalle") Integer id, Model model){
        DetallePedido detallePedido = detalleService.buscarPorId(id);
        if(detallePedido != null){
            model.addAttribute("detalleEncontrado", detallePedido);
        } else {
            model.addAttribute("error", "Detalle de pedido no encontrado: ");
        }
        return "detallePedido";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute("detalle") DetallePedido detallePedido ,Model model){
        DetallePedido actualizado = detalleService.actualizar(id, detallePedido);
        if(actualizado != null){
            return "redirect:/detallePedido";
        } else {
            model.addAttribute("error", "No se pudo actualizar el Detalle del pedido");
            return "detallePedido-form";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        detalleService.eliminar(id);
        return "redirect:/detallePedido";
    }

}
