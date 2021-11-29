package ClientService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.DTO.PhieuThueDTO;
import Rmi.Interface.IPhieuThueService;

public class PhieuThueService {
	private IPhieuThueService phieuThueService;
	private static PhieuThueService instance = null;

	private PhieuThueService() throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		phieuThueService = (IPhieuThueService) Naming
				.lookup(RmiConstant.ServerPath + ":" + RmiConstant.ServerPort + "/phieuThueService");
	}

	public synchronized static PhieuThueService getInstance() {
		if (instance == null) {
			try {
				instance = new PhieuThueService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public boolean addPhieuThue(PhieuThueDTO addObj) {
		try {
			return phieuThueService.addObject(addObj);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
}
