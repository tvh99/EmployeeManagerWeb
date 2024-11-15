package vn.com.stanford.staffmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.staffmanagement.entities.PhongBan;
import vn.com.stanford.staffmanagement.service.PhongBanService;

import java.util.List;

@Controller
public class PhongBanController {

    @Autowired
     PhongBanService phongBanService;

    @RequestMapping(value = "/admin/phongban" , method = RequestMethod.GET)
    public String hienThiDanhSachPhongBan(Model model) {

        List<PhongBan> lstPhongBan = phongBanService.layDanhSach();

        model.addAttribute("lstPhongBan", lstPhongBan);

        return "admin/QuanLyPhongBan";
    }


}
