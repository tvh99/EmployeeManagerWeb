package vn.com.stanford.staffmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import vn.com.stanford.staffmanagement.entities.NhanVien;
import vn.com.stanford.staffmanagement.entities.NhanVienMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModelMapper;
import vn.com.stanford.staffmanagement.entities.NhanVienModel;

import java.util.List;

@Repository
public class NhanVienImpl implements NhanVienDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Function to get total salary list of staff
     * @return
     */
    @Override
    public List<NhanVienModel> danhSachTongLuongNV(String tuKhoa, String maPhong, String maChucVu) {

        //Declare SQL command
        String strSQl = "Select MaNV,HoTen,GioiTinh,NgaySinh,DienThoai,Email,DiaChi,MaPhong,MaChucVu,TongLuong from vBangLuongNhanVien where 1=1";

        if(tuKhoa!= null && !tuKhoa.isEmpty())
        {
            strSQl += " and (MaNV = '" + tuKhoa + "' OR HoTen like '%" + tuKhoa + "%')";
        }

        if(maPhong!= null && !maPhong.isEmpty())
        {
            strSQl += " and MaPhong = '" + maPhong + "'";
        }

        if(maChucVu!= null && !maChucVu.isEmpty())
        {
            strSQl += " and MaChucVu = '" + maChucVu + "'";
        }


        //Execute the queries and return the result
        return jdbcTemplate.query(strSQl, new NhanVienModelMapper());
    }

    @Override
    public List<NhanVien> getList() {
        return null;
    }

    @Override
    public NhanVien findById(String maNV) {


        try {

            String strDetail = "Select MaNV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi, SoCMT, NgayCap, NoiCap, HeSoId, MaChucVu, MaPhong from NhanVien where MaNV = ?";


            return jdbcTemplate.queryForObject(strDetail, new NhanVienMapper(), maNV);
        }
        catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }


    @Override
    public boolean add(NhanVien objNV) {


        String strAdd = "Insert into NhanVien(MaNV, HoTen, GioiTinh, NgaySinh, DienThoai, Email, DiaChi, SoCMT, NgayCap, NoiCap, HeSoId, MaChucVu, MaPhong) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";


        boolean ketQua = false;


        ketQua = jdbcTemplate.update(strAdd, objNV.getMaNV(), objNV.getHoTen(), objNV.getGioiTinh(), objNV.getNgaySinh(), objNV.getDienThoai(), objNV.getEmail(), objNV.getDiaChi(), objNV.getSoCMT(), objNV.getNgayCap(), objNV.getNoiCap(), objNV.getHeSoId(), objNV.getMaChucVu(), objNV.getMaPhong()) > 0;

        return ketQua;
    }


    @Override
    public boolean update(NhanVien objNV) {

        String strUpdate = "Update NhanVien set HoTen = ?, GioiTinh = ?, NgaySinh = ?, DienThoai = ?, Email = ?, DiaChi = ?, SoCMT = ?, NgayCap = ?, NoiCap = ?, HeSoId = ?, MaChucVu = ?, MaPhong = ? where MaNV = ?";


        boolean ketQua = false;


        ketQua = jdbcTemplate.update(strUpdate, objNV.getHoTen(), objNV.getGioiTinh(), objNV.getNgaySinh(), objNV.getDienThoai(), objNV.getEmail(), objNV.getDiaChi(), objNV.getSoCMT(), objNV.getNgayCap(), objNV.getNoiCap(), objNV.getHeSoId(), objNV.getMaChucVu(), objNV.getMaPhong(), objNV.getMaNV()) > 0;

        return ketQua;
    }


    @Override
    public boolean delete(String maNV) {

        String strDelete = "Delete from NhanVien where MaNV = ?";


        boolean ketQua = false;


        ketQua = jdbcTemplate.update(strDelete, maNV) > 0;

        return ketQua;
    }
}
