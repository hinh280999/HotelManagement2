package Utilities;

import Entity.ChucVu;
import Entity.DichVu;
import Entity.KhachHang;
import Rmi.DTO.ChucVuDTO;
import Rmi.DTO.DichVuDTO;
import Rmi.DTO.KhachHangDTO;

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
}
