package CB;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallB extends UnicastRemoteObject implements ClientCBintf {

	protected ClientCallB() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void retourMsg(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
