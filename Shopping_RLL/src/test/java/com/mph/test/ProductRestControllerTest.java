package com.mph.test;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.mph.controller.CustomerRestController;
import com.mph.entity.Customer;
import com.mph.entity.Product;
import com.mph.service.CustomerServiceImpl;
import com.mph.service.ProductServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
public class ProductRestControllerTest {

	@InjectMocks
	ProductRestControllerTest productRestController;
	
	@Mock
	ProductServiceImpl productService;
	
	@Test
	public void testAllProduct() {
		Product product = new Product();
		List<Product> product1 = new ArrayList<>();
		product1.add(product);
		Assert.assertNotNull(productRestController.p());
		Assert.assertEquals(204, productRestController.allCustomer().getStatusCodeValue());
		when(productService.getCustomerList()).thenReturn(customer);
		Assert.assertNotNull(productRestController.allCustomer());
		Assert.assertEquals(1, productRestController.allCustomer().getBody().size());

	}

}