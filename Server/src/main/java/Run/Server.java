package Run;

public class Server {

	public static void main(String[] args) {
		
		SecurityManager securityManager = System.getSecurityManager();
		if (securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			securityManager = new SecurityManager();
			System.setSecurityManager(securityManager);
		}
		
		// ==== expose Service  ==========================
		

	}

}
