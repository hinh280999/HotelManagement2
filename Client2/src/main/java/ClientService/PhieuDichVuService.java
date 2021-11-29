package ClientService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.Interface.IPhieuDichVuService;

public class PhieuDichVuService {
	private IPhieuDichVuService phieuDichVuService;
	private static PhieuDichVuService instance = null;

	private PhieuDichVuService() throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}

		phieuDichVuService = (IPhieuDichVuService) Naming
				.lookup(RmiConstant.ServerPath + ":" + RmiConstant.ServerPort + "/phieuDichVuService");
	}

	public synchronized static PhieuDichVuService getInstance() {
		if (instance == null) {
			try {
				instance = new PhieuDichVuService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public boolean addPhieuDichVuByMaPhong(int maPhong, int maDichVu, int soluong) {
		try {
			return phieuDichVuService.addPhieuDichVuByMaPhong(maPhong, maDichVu, soluong);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
