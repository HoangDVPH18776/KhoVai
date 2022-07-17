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
//		Sub_CateRepository scsvs = new ;
//		 Category_Service ctsvs =new Category_Service() ;
//		System.out.println(ctsvs.findByID(1).getId());
		Set<Brand> brands = new Set<Brand>() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return false;
			}

			@Override
			public Iterator<Brand> iterator() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return new Object[0];
			}

			@Override
			public <T> T[] toArray(T[] a) {
				return null;
			}

			@Override
			public boolean add(Brand brand) {
				return false;
			}

			@Override
			public boolean remove(Object o) {
				return false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Brand> c) {
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				return false;
			}

			@Override
			public void clear() {

			}
		};
		brands.toArray();
		SpringApplication.run(KhoVaiApplication.class, args);
	}

}
