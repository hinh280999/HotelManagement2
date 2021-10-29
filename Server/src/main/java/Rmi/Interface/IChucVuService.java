package Rmi.Interface;

import java.rmi.Remote;

import Rmi.DTO.ChucVuDTO;

public interface IChucVuService extends Remote {
	boolean addChucVu(ChucVuDTO object);
	ChucVuDTO getChucVuById(int id);
	boolean updateChucVu(ChucVuDTO object);
	boolean deleteChucVu(int object);
}
