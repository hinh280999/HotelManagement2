package Run;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Rmi.Interface.IChucVuService;
import Rmi.Interface.IKhachHangService;
import Rmi.Interface.ITaiKhoanService;
import Rmi.Service.ChucVuService;
import Rmi.Service.KhachHangService;
import Rmi.Service.TaiKhoanService;

public class Server {

	public static void main(String[] args) throws RemoteException, NamingException {
		
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
		}
		
		// ==== expose Service  ==========================
		//IChucVuService chucVuService = new ChucVuService();
		ITaiKhoanService taiKhoanService = new TaiKhoanService();
		IKhachHangService khachHangService = new KhachHangService();
		
		
		// === public service  ============================================
		LocateRegistry.createRegistry(3000);
		Context context = new InitialContext();
		context.bind("rmi://HinhPc:3000/taiKhoanService", taiKhoanService);
		context.bind("rmi://HinhPc:3000/khachHangService", khachHangService);
		System.out.println("Server bound to the RMIRegistry");
	}

}
