package Rmi.Interface;

import java.rmi.Remote;

import Rmi.DTO.TaiKhoanDTO;

public interface ITaiKhoanService extends Remote {
	TaiKhoanDTO get(String tenTk);

	boolean update(int maNV, TaiKhoanDTO updateTk);

	boolean delete(String tenTK);

	boolean addTkToNhanVien(int maNv, TaiKhoanDTO tk);
}
