package Dao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Model.PageList;
import Rmi.DTO.KhachHangDTO;
import Rmi.Interface.IKhachHangService;

public class KhachHangService {
	private IKhachHangService khachHangService;
	private static KhachHangService instance = null;

	private KhachHangService() throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		khachHangService = (IKhachHangService) Naming
				.lookup(RmiConstant.ServerPath + ":" + RmiConstant.ServerPort + "/khachHangService");
	}

	public PageList<KhachHangDTO> searchListKhachHang(String tenKh, int page) throws RemoteException {
		return khachHangService.searchListKhachhang(tenKh, page);
	}

	public synchronized static KhachHangService getInstance() {
		if (instance == null) {
			try {
				instance = new KhachHangService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

}
