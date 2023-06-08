package com.salvador.springboot.app.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salvador.springboot.app.entidades.Cliente;
import com.salvador.springboot.app.entidades.Factura;
import com.salvador.springboot.app.entidades.ItemFactura;
import com.salvador.springboot.app.entidades.Producto;
import com.salvador.springboot.app.service.IClienteService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaControl {

	@Autowired
	IClienteService clienteService;

	private Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/form/{idCliente}")
	public String crearFactura(@PathVariable(value = "idCliente") Long idCliente, Model model,
			RedirectAttributes flash) {
		Cliente cliente = clienteService.findOne(idCliente);
		if (cliente == null) {
			flash.addFlashAttribute("error", "No se encuentra el cliente en la base de datos");
			return "redirect: /listaClientes";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		model.addAttribute("titulo", "Crear factura");
		model.addAttribute("factura", factura);
		return "factura/form";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProducto(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}

	@PostMapping("/form/")
	public String guardarFactura(@Valid Factura factura, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Crear factura");
			return "factura/form";
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", "Crear factura");
			model.addAttribute("error", "La factura debe tener productos agregados");
			return "factura/form";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);
			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);
			log.info("ID: " + itemId[i].toString() + " , cantidad: " + cantidad.toString());
		}
		clienteService.saveFactura(factura);
		status.setComplete();
		flash.addFlashAttribute("success", "Factura registrada");
		return "redirect:/verDetalle/" + factura.getCliente().getId();
	}

	@GetMapping("/verFactura/{id}")
	public String ver(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash) {
		Factura factura = clienteService.obtenerFacturaCompleta(id); // clienteService.findFacturaById(id);
		if (factura == null) {
			flash.addFlashAttribute("error", "La factura no existe en la bd");
			return "redirect:/listar";
		}

		model.addAttribute("factura", factura);
		model.addAttribute("titulo", "Factura: ".concat(factura.getDescripcion()));
		return "factura/verFactura";
	}

	@GetMapping("eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		Factura factura = clienteService.findFacturaById(id);
		if (factura != null) {
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success", "Factura borrada ");
			return "redirect:/verDetalle/" + factura.getCliente().getId();
		}
		flash.addFlashAttribute("error", "La factura no existe en la base de datos");
		return "redirect:/listaClientes";
	}

}
