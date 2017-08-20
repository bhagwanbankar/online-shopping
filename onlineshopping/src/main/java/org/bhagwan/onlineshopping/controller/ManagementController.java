package org.bhagwan.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.bhagwan.onlineshopping.util.FileUploadUtility;
import org.bhagwan.onlineshopping.validator.ProductValidator;
import org.bhagwan.shoppingbackend.dao.CategoryDAO;
import org.bhagwan.shoppingbackend.dao.ProductDAO;
import org.bhagwan.shoppingbackend.dto.Category;
import org.bhagwan.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation){
		ModelAndView mv= new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title", "Manage Products");
		Product nproduct= new Product();
		nproduct.setActive(true);
		nproduct.setSupplierId(1);
		mv.addObject("product",nproduct);
		if(operation!=null){
			if(operation.equals("product")){
				mv.addObject("message","Product added Successfully");
			}else if(operation.equals("category")){
				mv.addObject("message","Category added Successfully");
			}
		}
		return mv;
	}
	//handling product submission
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results, Model model,HttpServletRequest request){
		
		if(mProduct.getId()==0){
			new ProductValidator().validate(mProduct, results);
		}else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, results);
			}
		}
		
		//check if there are any error
		if(results.hasErrors()){
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed For Product Submission");
			return "page";
		}
		logger.info(mProduct.toString());
		
		if(mProduct.getId()==0){
			//create new Product record if id is 0
			productDAO.add(mProduct);
		}else{
			//update the product if id is not 0
			productDAO.update(mProduct);
		}
		if(!mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id){
		
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		product.setActive(!isActive);
		productDAO.update(product);
		return (isActive)?"You have successfully deactivated product with id "+id:"You have successfully activated product with id "+id;
	}
	
	//to handle product submission
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		//Add new Category
		
		categoryDAO.add(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id){
		ModelAndView mv= new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title", "Manage Products");
		Product nproduct= productDAO.get(id);
		//Set the product fetched
		mv.addObject("product",nproduct);
		
		
		return mv;
	}
	
	
	//returning categories for all request mapping 
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
		
	}
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	
	
}
