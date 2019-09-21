package org.thesecretintelligence.demonic.api;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ApiServer {
	
	public String domain = null;
	
	public void findServer() {
		try {
		String url = "http://bins.thesecretintelligence.org/3poia9/API.html";
        URLConnection openConnection = new URL(url).openConnection();
        openConnection.addRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(new InputStreamReader(openConnection.getInputStream()));
        domain = scan.nextLine();
        	return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
}
