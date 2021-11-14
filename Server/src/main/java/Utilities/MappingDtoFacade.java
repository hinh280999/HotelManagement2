package Utilities;

import Entity.ChucVu;
import Entity.DichVu;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.PhieuThue;
import Entity.Phong;
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
		NhanVien rv = new Entity.NhanVien(objectDTO.getTen(), objectDTO.getEmail(), objectDTO.getGioiTinh(),
				objectDTO.getSdt());

		ChucVu cv = new ChucVu();
		cv.setMaCV(objectDTO.getChucVu_id());

		TaiKhoan tk = new TaiKhoan(objectDTO.getTaiKhoan().getTenTK(), objectDTO.getTaiKhoan().getMatKhau(),
				objectDTO.getTaiKhoan().isAdmin());

		rv.setChucVu(cv);
		rv.setTaiKhoan(tk);
		return rv;
	}

	public static NhanVienDTO mapToNhanVienDTO(NhanVien nhanVien) {
		NhanVienDTO rvDto = new NhanVienDTO(nhanVien.getTen(), nhanVien.getEmail(), nhanVien.getGioiTinh(),
				nhanVien.getSdt());

		TaiKhoanDTO tkDto = new TaiKhoanDTO(nhanVien.getTaiKhoan().getTenTK(), nhanVien.getTaiKhoan().getMatKhau(),
				nhanVien.getTaiKhoan().isAdmin());

		rvDto.setChucVu_id(nhanVien.getChucVu().getMaCV());
		rvDto.setTaiKhoan(tkDto);
		return rvDto;
	}

	public static PhieuThue mapToPhieuThueAdd(PhieuThueDTO objectDTO) {
		Phong phong = new Phong();
		phong.setMaP(objectDTO.getPhong_id());

		NhanVien nv = new NhanVien(objectDTO.getNhanVien_id());

		KhachHang kh = new KhachHang(objectDTO.getKhachHang_id());

		PhieuThue rv = new PhieuThue(objectDTO.getNgayDat(), objectDTO.getNgayKetThuc(), phong, nv, kh);

		rv.setNgayLap((objectDTO.getNgayLap() != null) ? objectDTO.getNgayLap() : null);
		rv.setNgayNhan((objectDTO.getNgayNhan() != null) ? objectDTO.getNgayNhan() : null);
		rv.setNgayTra((objectDTO.getNgayTra() != null) ? objectDTO.getNgayTra() : null);

		rv.setTrangThai(objectDTO.getTrangThai());
		return rv;
	}

	public static PhieuThueDTO mapToPhieuThueDTO(PhieuThue phieuThue) {
		// public PhieuThueDTO(Date ngayDat, Date ngayKetThuc, Date ngayLap, PhongDTO
		// phong, NhanVienDTO nhanVien,KhachHangDTO khachHang)
		PhieuThueDTO rvDto = new PhieuThueDTO();
		rvDto.setMaPT(phieuThue.getMaPT());
		rvDto.setNgayLap(phieuThue.getNgayLap());

		rvDto.setNgayDat(phieuThue.getNgayDat());
		rvDto.setNgayKetThuc(phieuThue.getNgayKetThuc());

		rvDto.setNgayNhan((phieuThue.getNgayNhan() != null) ? phieuThue.getNgayNhan() : null);
		rvDto.setNgayTra((phieuThue.getNgayTra() != null) ? phieuThue.getNgayTra() : null);

		rvDto.setPhong_id(phieuThue.getPhong().getMaP());
		rvDto.setNhanVien_id(phieuThue.getNhanVien().getMaNV());
		rvDto.setKhachHang_id(phieuThue.getKhachHang().getMaKH());

		rvDto.setTrangThai(phieuThue.getTrangThai());
		return rvDto;
	}
}
