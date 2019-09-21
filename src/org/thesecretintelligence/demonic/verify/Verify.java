package org.thesecretintelligence.demonic.verify;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.thesecretintelligence.demonic.api.ApiServer;

public class Verify {
	
	ApiServer server = new ApiServer();
	
	private String id = "Error Loading.....";
	
	public String getId() {
		return id;
	}
	
	public String setId(String newId) {
		return id = newId;
	}
	
	protected boolean verify(String id) {
		server.findServer();
		String url = null;
		this.id = id;
		try {
            url = "http://" + server.domain + "/api.php?key=" + id + "&host=1.1.1.1&port=80&time=5&method=check";
            URLConnection openConnection = new URL(url).openConnection();
            openConnection.addRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(new InputStreamReader(openConnection.getInputStream()));
            setId(scan.nextLine());
            System.out.println("id - " + getId());
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
		
	}

}
