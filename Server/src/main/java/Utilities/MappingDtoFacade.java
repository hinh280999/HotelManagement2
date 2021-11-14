package Utilities;

import Entity.ChucVu;
import Entity.DichVu;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuThue;
import Entity.TaiKhoan;
import Rmi.DTO.ChucVuDTO;
import Rmi.DTO.DichVuDTO;
import Rmi.DTO.KhachHangDTO;
import Rmi.DTO.LoaiPhongDTO;
import Rmi.DTO.NhanVienDTO;
import Rmi.DTO.PhieuThueDTO;
import Rmi.DTO.TaiKhoanDTO;

public class MappingDtoFacade {

	public static ChucVu mapToChucVu(ChucVuDTO mapObject) {
		ChucVu returnVL = new ChucVu();
		returnVL.setLuong(mapObject.getLuong());
		returnVL.setTenCV(mapObject.getTenCV());
		return returnVL;
	}

	public static ChucVuDTO mapToChucVuDTO(ChucVu chucvu) {
		return new ChucVuDTO(chucvu.getMaCV(), chucvu.getTenCV(), chucvu.getLuong());
	}

	public static DichVu mapToDichVu(DichVuDTO mapObject) {
		DichVu returnVL = new DichVu();
		returnVL.setTenDv(mapObject.getTenDv());
		returnVL.setDonGia(mapObject.getDonGia());
		return returnVL;
	}

	public static DichVuDTO mapToDichVuDTO(DichVu mapObject) {
		DichVuDTO returnVL = new DichVuDTO(mapObject.getTenDv(), mapObject.getDonGia());
		returnVL.setMaDv(mapObject.getMaDv());
		return returnVL;
	}

	public static KhachHang mapToKhachHang(KhachHangDTO DTO) {
		return new KhachHang(DTO.getTen(), DTO.getEmail(), DTO.getSdt(), DTO.getDiaChi(), DTO.getSoCMND());
	}

	public static KhachHangDTO mapToKhachHangDTO(KhachHang khachHang) {
		KhachHangDTO rv = new KhachHangDTO(khachHang.getTen(), khachHang.getEmail(), khachHang.getSdt(),
				khachHang.getDiaChi(), khachHang.getSoCMND());
		rv.setMaKH(khachHang.getMaKH());
		return rv;
	}

	public static LoaiPhong mapToLoaiPhong(LoaiPhongDTO Dto) {
		return new LoaiPhong(Dto.getTenLP(), Dto.getDonGia());
	}

	public static LoaiPhongDTO mapToLoaiPhongDTO(LoaiPhong loaiPhong) {
		LoaiPhongDTO rv = new LoaiPhongDTO(loaiPhong.getTenLP(), loaiPhong.getDonGia());
		rv.setMaLP(loaiPhong.getMaLP());
		return rv;
	}

	public static NhanVien mapToNhanVien(NhanVienDTO objectDTO) {
		NhanVien rv = new Entity.NhanVien(objectDTO.getTen(), objectDTO.getEmail(), objectDTO.getGioiTinh(), objectDTO.getSdt());
		
		ChucVu cv = mapToChucVu(objectDTO.getChucVu());
		cv.setMaCV(objectDTO.getChucVu().getMaCV());
		
		TaiKhoan tk = new TaiKhoan(objectDTO.getTaiKhoan().getTenTK(), objectDTO.getTaiKhoan().getMatKhau(), objectDTO.getTaiKhoan().isAdmin());
		
		rv.setChucVu(cv);
		rv.setTaiKhoan(tk);
		return rv;
	}

	public static NhanVienDTO mapToNhanVienDTO(NhanVien nhanVien) {
		NhanVienDTO rvDto = new NhanVienDTO(nhanVien.getTen(), nhanVien.getEmail(), nhanVien.getGioiTinh(), nhanVien.getSdt());
		
		ChucVuDTO cvDto = mapToChucVuDTO(nhanVien.getChucVu());
		TaiKhoanDTO tkDto = new TaiKhoanDTO(nhanVien.getTaiKhoan().getTenTK(), nhanVien.getTaiKhoan().getMatKhau(), nhanVien.getTaiKhoan().isAdmin());
		
		rvDto.setChucVu(cvDto);
		rvDto.setTaiKhoan(tkDto);
		return rvDto;
	}

	public static PhieuThue mapToPhieuThue(PhieuThueDTO objectDTO) {
		//PhieuThue rv = new PhieuThue(null, null, null, null, null)
		return null;
	}
}
