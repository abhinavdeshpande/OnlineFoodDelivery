package online.food.delivery;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.cg.ofd.bean.Address;
import com.cg.ofd.bean.Category;
import com.cg.ofd.bean.Items;
import com.cg.ofd.bean.Restaurant;
import com.cg.ofd.service.ItemService;
import com.cg.ofd.service.ItemServiceImpl;
import com.cg.ofd.service.RestaurantService;
import com.cg.ofd.service.RestaurantServiceImpl;

class RestaurantTest {

	@Test
	void testAddRestaurant() {
		
		Address address= new Address(530,"gopalpatti","lane3","hadapsar","pune","ms","india","555555");
		
		Category cat = new Category(16,"icecream2");
		Category cat2 = new Category(17,"icecream3");

		
		List<Items> item1 = new ArrayList<>(); 
		Items i1 = new Items(114,"item6",cat,45,60);
		Items i2 = new Items(115,"item7",cat2,46,61);
		item1.add(i1);
		item1.add(i2);
		
		
		Restaurant restro = new Restaurant(100009,"KFC",address,item1,"Sulekha","9898989898");
		RestaurantService restroservice = mock(RestaurantServiceImpl.class);
		when(restroservice.addRestaurant(restro)).thenReturn(restro);
		
		Restaurant restro2 = restroservice.addRestaurant(restro);
		assertEquals(restro,restro2);
		
	}
	
	@Test
	public void findRestaurant() {
		Address address= new Address(530,"gopalpatti","lane3","hadapsar","pune","ms","india","555555");
		
		Category cat = new Category(16,"icecream2");
		Category cat2 = new Category(17,"icecream3");

		
		List<Items> item1 = new ArrayList<>(); 
		Items i1 = new Items(114,"item6",cat,45,60);
		Items i2 = new Items(115,"item7",cat2,46,61);
		item1.add(i1);
		item1.add(i2);
		
		Restaurant restro = new Restaurant(100009,"KFC",address,item1,"Sulekha","9898989898");
		
		RestaurantService restroservice = mock(RestaurantServiceImpl.class);
		 restroservice.addRestaurant(restro);
		 
	        when(restroservice.findOneRestaurant(100009)).thenReturn(restro);
	         Restaurant r1 =restroservice.findOneRestaurant(100009);
	         
	        assertEquals("KFC",r1.getRestaurantName());
	}
	
	


}
