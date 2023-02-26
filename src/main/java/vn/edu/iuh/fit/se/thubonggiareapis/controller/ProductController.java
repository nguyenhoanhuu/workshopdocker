package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.iuh.fit.se.thubonggiareapis.entity.Product;
import vn.edu.iuh.fit.se.thubonggiareapis.service.ProductService;

@Controller
@RestController()
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/save")
	public Product save(Product product) {
		 productService.addProduct(product);
		 return product;
	}
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.getProducts();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}

	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "new_product";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.addProduct(product);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = productService.getProductById(id);
		mav.addObject("product", product);

		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
	    productService.deleteProduct(id);
	    return "redirect:/";       
	}
}