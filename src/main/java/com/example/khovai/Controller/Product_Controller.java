package com.example.khovai.Controller;

import com.example.khovai.DomainModels.Brand;
import com.example.khovai.DomainModels.Product;
import com.example.khovai.DomainModels.Sub_Cate;
import com.example.khovai.Service.Brand_Service;
import com.example.khovai.Service.Product_Service;
import com.example.khovai.Service.Status_Service;
import com.example.khovai.Service.Sub_Cate_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

@Controller
public class Product_Controller {
    @Autowired private Product_Service svs;
    @Autowired private Brand_Service brasvs;
    @Autowired private Sub_Cate_Service subsvs;

    @GetMapping("/list_product")
    public String showList(Model md){
        Page<Product> page = svs.listAll(1);
        int totalPage = page.getTotalPages();
        List<Product> lst = page.getContent();
        md.addAttribute("listproduct",lst);
        md.addAttribute("totalPage",totalPage);
        md.addAttribute("currentPage",1);
        System.out.println("aaaa");
        return "list_product";
    }
    @GetMapping("/list_product/page/{pageNumber}")
    public String listByPage(Model md, @PathVariable("pageNumber") int currentPage){
        Page<Product> page = svs.listAll(currentPage);
        int totalPage = page.getTotalPages();
        List<Product> lst = page.getContent();
        md.addAttribute("listproduct",lst);
        md.addAttribute("totalPage",totalPage);
        md.addAttribute("currentPage",1);
        return "list_product";
    }
    @GetMapping("/product_form/delete")
    public String getID(Model md ){
        return "product_getID";
    }
    @PostMapping("/product/delete")
    public String delID(Model md, @RequestParam("getid")int id, RedirectAttributes ra){
        svs.delBra_Pro(id);
        svs.del(id);
        ra.addFlashAttribute("message","Xoas thành công");
        return "redirect:/list_product";
    }
    @GetMapping("/product_form/new")
    public String showForm(Model md){
        md.addAttribute("product",new Product());
        md.addAttribute("pageTitle","Add new Product");
        return "product_form";
    }
    @PostMapping("/product_form/save")
    public String saveProduct(@RequestParam("brandId") int idbrand ,@RequestParam("sub_cate_id") int idsub, Product pr , Model md,RedirectAttributes ra) throws Exception {
        if(!brasvs.checkExist(idbrand)){
            md.addAttribute("message", "BrandID đấy k tồn tại bạn êy");
            return "/product_form";
        }
        if(!subsvs.checkExist(idsub)){
            md.addAttribute("message", "Sub_Cate ID đấy k tồn tại bạn êy");
            return "/product_form";
        }
        if(pr.getOrigin_price()>=pr.getSell_price()){
            md.addAttribute("message", "Bán thế để lỗ hả bạn");
            return "/product_form";
        }
        if(pr.getQuantity()<0){
            md.addAttribute("message", "Nhập sai sl kìa bb");
            return "/product_form";
        }
        pr.setSub_cate(subsvs.get(idsub));
        pr.getBrands().add(brasvs.getByID(idbrand));
        ra.addFlashAttribute("message","Thêm thành công");
        svs.save(pr);
        return "redirect:/list_product";
    }
    @GetMapping("/product_form/edit/{id}")
    public String showEditForm (@PathVariable("id") int id, Model md , RedirectAttributes ra){
        try{
            Product pr = svs.getByID(id);
            md.addAttribute("product",pr);
            md.addAttribute("sub_cate_id",pr.getSub_cate().getId());
            md.addAttribute("pageTitle","Edit Product_ID:"+id);
            return "/product_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message" ,"Không tồn tại người này");
            return "redirect:/list_product";
        }
    }
}
