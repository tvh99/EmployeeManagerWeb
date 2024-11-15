package vn.com.stanford.staffmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.com.stanford.staffmanagement.entities.HeSoLuong;
import vn.com.stanford.staffmanagement.service.HeSoLuongService;

import java.util.List;

@Controller
public class HeSoLuongController {

    @Autowired
    HeSoLuongService heSoLuongService;

    @RequestMapping(value = "/admin/hesoluong" , method = RequestMethod.GET)
    public String hienThiDanhSachHeSoLuong(Model model) {

        List<HeSoLuong> lstHeSoLuong = heSoLuongService.layDanhSach();

        model.addAttribute("lstHeSoLuong", lstHeSoLuong);

        return "admin/QuanLyHeSoLuong";
    }
}
