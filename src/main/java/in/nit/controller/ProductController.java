package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Product;
import in.nit.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;

	@RequestMapping("/all")
	public String showProducts(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductsData";

	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		// deleting row based on PK
		service.deleteProduct(id);
		// fetching new data
		List<Product> list = service.getAllProducts();
		// send data to UI

		model.addAttribute("list", list);
		model.addAttribute("message", id + "deleted");
		return "ProductsData";
		// return "redirect:../all";

	}

	@RequestMapping("/view/{id}")
	public String getOneProduct(@PathVariable("id") Integer id, Model model) {
		Optional<Product> opt = service.getOneProduct(id);
		if (opt.isPresent()) {
			model.addAttribute("ob", opt.get());
		} else {
			model.addAttribute("message", "No Data found");
		}
		return "ProductOne";

	}

	@RequestMapping("/reg")
	public String showRegPage(Model model) {
		model.addAttribute("product", new Product());
		return "ProductReg";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product, Model model) {
		Integer id = service.saveProduct(product);
		String message = "Product saved with:" + id;
		model.addAttribute("message", message);
		// clear form
		model.addAttribute("product", new Product());
		return "ProductReg";
	}

	@RequestMapping("/edit/{id}")
	public String showEditPage(@PathVariable("id") Integer id, Model model) {
		Optional<Product> ob = service.getOneProduct(id);
		if (ob.isPresent()) {
			model.addAttribute("product", ob.get());

		} else {
			model.addAttribute("product", new Product());
		}
		return "ProductEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute Product product, Model model) {
		Integer id = service.saveProduct(product);
		model.addAttribute("message", "Product updated:" + id);
		// fetch new data from db
		List<Product> list = service.getAllProducts();
		// send data to UI
		model.addAttribute("list", list);
		return "ProductsData";
	}
}
