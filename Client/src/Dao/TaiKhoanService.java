package Dao;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.DTO.TaiKhoanDTO;
import Rmi.Interface.ITaiKhoanService;

public class TaiKhoanService {
	private ITaiKhoanService tkService;

	public TaiKhoanService() throws MalformedURLException, RemoteException, NotBoundException {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		tkService = (ITaiKhoanService) Naming
				.lookup(RmiConstant.ServerPath + ":" + RmiConstant.ServerPort + "/taiKhoanService");
	}

	public TaiKhoanDTO getTaiKhoanByName(String tenTk) throws RemoteException {
		TaiKhoanDTO rv = tkService.get(tenTk);
		if (rv != null)
			return rv;
		return null;
	}

}
