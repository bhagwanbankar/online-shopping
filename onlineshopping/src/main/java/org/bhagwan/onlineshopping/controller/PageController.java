package org.bhagwan.onlineshopping.controller;

import org.bhagwan.shoppingbackend.dao.CategoryDAO;
import org.bhagwan.shoppingbackend.dao.ProductDAO;
import org.bhagwan.shoppingbackend.dto.Category;
import org.bhagwan.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Home");
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome",true);
		
		return mv;
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		
		return mv;
	}
	/*
	 * Methods to load all products and based on category
	 */
	@RequestMapping(value={"/show/all/products"})
	public ModelAndView showAllProducts(){
		
		ModelAndView mv= new ModelAndView("page");
		mv.addObject("title","All Products");
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProduts",true);
		
		return mv;
	}

	/*
	 * Methods to load all products and based on category
	 */
	@RequestMapping(value={"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		
		ModelAndView mv= new ModelAndView("page");
		
		//categoryDAO to fetch a single category
		Category category= null;
		category= categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		//passing list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing single category
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProduts",true);
		
		return mv;
	}
	
	/*
	 * Methods to load single product
	 */
	@RequestMapping(value={"/show/{id}/product"})
	public ModelAndView showSingleProduct(@PathVariable int id){
		
		ModelAndView mv= new ModelAndView("page");
		
		Product product=productDAO.get(id);
		//Update View Count
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		
		//passing single product
		mv.addObject("product", product);
		mv.addObject("userClickShowProdut",true);
		
		return mv;
	}
	
	
}
