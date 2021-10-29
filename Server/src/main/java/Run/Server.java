package Run;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Rmi.Interface.IChucVuService;
import Rmi.Service.ChucVuService;

public class Server {

	public static void main(String[] args) throws RemoteException, NamingException {
		
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
		}
		
		// ==== expose Service  ==========================
		IChucVuService chucVuService = new ChucVuService();
		
		
		// === public service  ============================================
		LocateRegistry.createRegistry(9091);
		Context context = new InitialContext();
		context.bind("rmi://localhost:9091/chucVuService", chucVuService);
		System.out.println("Server bound to the RMIRegistry");
	}

}
