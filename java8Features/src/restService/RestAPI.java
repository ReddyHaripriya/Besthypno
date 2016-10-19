package restService;

import java.net.HttpURLConnection;
import java.net.URL;

public class RestAPI {
	
	public static void main(String args[]){
		/*String url1="http://zip4.usps.com/zip4/zcl_0_results.jsp?visited=1&pagenumber=0&firmname=&address2="; // 2 Broadway
        String url2="&address1=&city="; //NEW YORK
        String url3="&state=";//NY
        String url4="&urbanization=&zip5=";   
        
        String fullurl=url1+street+url2+city+url3+state+url4;*/
		
		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

		System.out.println("\nTesting 2 - Send Http POST request");
		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "http://www.google.com/search?q=mkyong";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());

	}

	}

}
