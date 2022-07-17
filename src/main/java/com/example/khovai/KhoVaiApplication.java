package com.example.khovai;

import com.example.khovai.DomainModels.Brand;
import com.example.khovai.Repository.Sub_CateRepository;
import com.example.khovai.Service.Category_Service;
import com.example.khovai.Service.Sub_Cate_Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

@SpringBootApplication
public class KhoVaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhoVaiApplication.class, args);
	}

}
