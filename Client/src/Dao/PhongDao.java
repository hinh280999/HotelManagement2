package Dao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.DTO.PhongDTO;
import Rmi.Interface.IPhongService;

public class PhongDao {
	private IPhongService phongService;
	private static PhongDao instance = null;

	private PhongDao() throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		phongService = (IPhongService) Naming
				.lookup(RmiConstant.ServerPath + ":" + RmiConstant.ServerPort + "/phongService");
	}

	public PhongDTO getPhongTrong(int maLP) {
		try {
			PhongDTO rvPhong = phongService.getPhongTrong();
			return rvPhong;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;

	}

	public synchronized static PhongDao getInstance() {
		if (instance == null) {
			try {
				instance = new PhongDao();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
