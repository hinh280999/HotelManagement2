package Dao;

import Rmi.Interface.IPhongService;

public class TaiKhoanDao {
	private IPhongService Dao;

	public TaiKhoanDao() {
		SecurityManager manager = System.getSecurityManager();
		if (manager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
	}

}
