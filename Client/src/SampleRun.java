import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Rmi.DTO.ChucVuDTO;
import Rmi.Interface.IChucVuService;

public class SampleRun {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		IChucVuService chucVuService = (IChucVuService) Naming.lookup("rmi://localhost:9091/chucVuService");
		
		ChucVuDTO Dto = new ChucVuDTO();
		Dto.setTenCV("Rmi ChucVu");
		Dto.setLuong(1.0);
		
		if (chucVuService.addChucVu(Dto)) System.out.println("Add From Client success");
		else System.out.println("Add from client fail");
	}

}
