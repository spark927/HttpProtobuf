package test;

import java.io.InputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.alibaba.fastjson.JSONObject;

import proto.Login.login;

public class Demo 
{
	
	public static String Login(String type, String url, JSONObject jsonObject) throws Exception{
		
		//格式为：{"username":"tom","password":"11111"}
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        
        login.Builder builder = login.newBuilder();
    	builder.setName(username);
    	builder.setPwd(password);
    	login req = builder.build();

		byte[] data = req.toByteArray();
		
		TrustHttp.trustAllHttpsCertificates();  
		HttpsURLConnection.setDefaultHostnameVerifier(hv); 
		
		String code = HttpConnect.httpPost(type, url, data);
		
		return code;
		
	}

	static HostnameVerifier hv = new HostnameVerifier() {  
	  public boolean verify(String urlHostName, SSLSession session) {  
	      System.out.println("Warning: URL Host: " + urlHostName + " vs. "  
	                         + session.getPeerHost());  
	      return true;  
	  }  
	}; 
}
