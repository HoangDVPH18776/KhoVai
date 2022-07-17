package com.example.khovai.Controller;

import com.example.khovai.DomainModels.Category;
import com.example.khovai.DomainModels.Sub_Cate;
import com.example.khovai.Service.Category_Service;
import com.example.khovai.Service.Sub_Cate_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class Sub_Cate_Controller {

    @Autowired private Sub_Cate_Service svs;
    @Autowired private Category_Service ctsvs;


    @GetMapping("/list_sub_cate")
    public String showList(Model md){
        Page<Sub_Cate> listsub = svs.listAll(1);
        int totalPage = listsub.getTotalPages();
        md.addAttribute("listsub",listsub);
        md.addAttribute("currentPage",1);
        md.addAttribute("totalPage",totalPage);
        return "list_sub_cate";
    }
    @GetMapping("/list_sub_cate/page/{page}")
    public String showListByPage(Model md , @PathVariable("page") int pageNumber){
        Page<Sub_Cate> listsub = svs.listAll(pageNumber);
        int totalPage = listsub.getTotalPages();
        md.addAttribute("listsub",listsub);
        md.addAttribute("currentPage",pageNumber);
        md.addAttribute("totalPage",totalPage);
        return "list_sub_cate";
    }
    @GetMapping("/list_sub_cate/new")
    public String showNewForm(Model md){

        md.addAttribute("sub_cate",new Sub_Cate());
        md.addAttribute("pageTitle","Add new Sub_Cate");
//        md.addAttribute("category",1);
        return "list_sub_cate_form";
    }
    @PostMapping("/list_sub_cate/save")
    public String saveSubCate(@RequestParam("category") int idcate , Sub_Cate sc , Model md){

        sc.setCategory(ctsvs.findByID(idcate));
        svs.saveSub_Cate(sc);
    return "redirect:/list_sub_cate";
    }
    @GetMapping("/list_sub_cate/edit/{id}")
    public String showEditForm(@PathVariable("id") int id,Model md , RedirectAttributes ra){
        try{
            Sub_Cate sc = svs.get(id);
            md.addAttribute("sub_cate",sc);
            md.addAttribute("pageTitle","Edit Sub_Cate_ID:"+id);
            return "list_sub_cate_form";
        } catch (Exception e) {
            ra.addFlashAttribute("message" ,"Không tồn tại người này");
            return "redirect:/list_sub_cate_form";
        }
    }


}
