package Rmi.Service;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import Dao.Impliment.PhieuThueDao;
import Dao.Interface.IPhieuThue;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.PhieuThue;
import Entity.Phong;
import Rmi.DTO.PhieuThueDTO;
import Rmi.Interface.IPhieuThueService;
import Utilities.MappingDtoFacade;

public class PhieuThueService extends UnicastRemoteObject implements IPhieuThueService {
	private static final long serialVersionUID = 1L;
	private IPhieuThue phieuThueDao;

	public PhieuThueService() throws RemoteException {
		phieuThueDao = new PhieuThueDao();
	}


	@Override
	public boolean addObject(PhieuThueDTO objectDTO) throws RemoteException {
		//(Date ngayDat, Date ngayKetThuc, Phong phong, NhanVien nhanVien, KhachHang khachHang)
		Phong phong = new Phong(objectDTO.getPhong().getTen());
		phong.setMaP(objectDTO.getPhong().getMaP());
		
		KhachHang kh = new KhachHang();
		kh.setMaKH(objectDTO.getKhachHang().getMaKH());
		//PhieuThue addObj = MappingDtoFacade.mapToPhieuThue(objectDTO.getNgayDat(),objectDTO.getNgayKetThuc(),phong,);
		return false;
	}

	@Override
	public PhieuThueDTO getObjectById(int id) throws RemoteException {
		return null;
	}

	@Override
	public boolean updateObject(PhieuThueDTO objectDTO) throws RemoteException {
		return false;
	}

	@Override
	public boolean deleteObjectById(int objectId) throws RemoteException {
		return false;
	}

}
