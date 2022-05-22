package com.boot.example;

import com.boot.example.service.BootService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BootExampleApplicationTests {
    
    @Autowired
    BootService bootService;

	@Test
	void contextLoads() {
	    
	}
	
	@Test
	void isUserAllowCreateAction() {
	    String userRole = "";
	    
	    userRole = "SuperUser";
	    Assertions.assertEquals(true, bootService.isUserAllowCreateAction(userRole));
	    
	    userRole = "Operator";
	    Assertions.assertEquals(true, bootService.isUserAllowCreateAction(userRole));
	    
	    userRole = "Manager";
	    Assertions.assertEquals(false, bootService.isUserAllowCreateAction(userRole));
	}

}
