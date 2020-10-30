package online.food.delivery;


import org.springframework.beans.factory.annotation.Autowired;

import com.cg.ofd.controller.CategoryController;
import com.cg.ofd.service.CategoryService;

public class CategoryTest {

	@Autowired
	private CategoryService catservice;
	
	@Autowired
	private CategoryController cc;
	
	
}
