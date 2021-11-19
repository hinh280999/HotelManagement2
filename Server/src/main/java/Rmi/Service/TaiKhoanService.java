package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Dao.Impliment.TaiKhoanDao;
import Dao.Interface.ITaiKhoan;
import Entity.TaiKhoan;
import Rmi.DTO.TaiKhoanDTO;
import Rmi.Interface.ITaiKhoanService;
import Utilities.MappingDtoFacade;

public class TaiKhoanService extends UnicastRemoteObject implements ITaiKhoanService {
	private static final long serialVersionUID = 1L;
	private ITaiKhoan taiKhoanDao;

	public TaiKhoanService() throws RemoteException {
		taiKhoanDao = new TaiKhoanDao();
	}

	@Override
	public TaiKhoanDTO get(String tenTk) {
		TaiKhoanDTO rv = MappingDtoFacade.mapToTaiKhoanDTO(taiKhoanDao.get(tenTk));
		return rv;
	}

	@Override
	public boolean update(int maNV, TaiKhoanDTO updateTk) {
		TaiKhoan updateObj = new TaiKhoan(updateTk.getTenTK(), updateTk.getMatKhau(), updateTk.isAdmin());
		return taiKhoanDao.update(maNV, updateObj);
	}

	@Override
	public boolean delete(String tenTK) {

		return taiKhoanDao.delete(tenTK);
	}

	@Override
	public boolean addTkToNhanVien(int maNv, TaiKhoanDTO tk) {
		TaiKhoan addObj = new TaiKhoan(tk.getTenTK(), tk.getMatKhau(), tk.isAdmin());
		return taiKhoanDao.addTkToNhanVien(maNv, addObj);
	}

}
