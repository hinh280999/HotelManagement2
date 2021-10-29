package Utilities;

import Entity.ChucVu;
import Rmi.DTO.ChucVuDTO;

public class MappingChucVuDTO {

	public static ChucVu mapToChucVu(ChucVuDTO mapObject) {
		ChucVu returnVL = new ChucVu();
		returnVL.setLuong(mapObject.getLuong());
		returnVL.setTenCV(mapObject.getTenCV());
		return returnVL;
	}

	public static ChucVuDTO mapToChucVuDTO(ChucVu chucvu) {
		return new ChucVuDTO(chucvu.getMaCV(), chucvu.getTenCV(), chucvu.getLuong());
	}
}
