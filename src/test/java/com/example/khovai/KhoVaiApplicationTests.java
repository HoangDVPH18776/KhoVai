package com.example.khovai;

import com.example.khovai.Service.Brand_Service;
import com.example.khovai.Service.Product_Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KhoVaiApplicationTests {
	@Autowired private Product_Service prosvs;
	@Autowired private Brand_Service brasvs;
	@Test
	void contextLoads() {
		System.out.println(brasvs.getByID(3).getId());
	}

}
