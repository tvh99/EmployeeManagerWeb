package vn.com.stanford.staffmanagement.model;

import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;

import java.util.List;

public interface NhanVienDao extends IHanhDong<NhanVien, String> {



    List<NhanVienModel> danhSachTongLuongNV(String tuKhoa, String maPhong, String maChucVu);

}
