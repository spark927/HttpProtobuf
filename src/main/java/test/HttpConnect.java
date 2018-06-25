package test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 请求
 * @author spark
 *
 */
public class HttpConnect {
	
	public static String httpPost(String type, String url, byte[] PostData) {
        URL u = null;
        HttpURLConnection con = null;
        InputStream inputStream = null;
        String resultCode = null;

        try {
            u = new URL(url);
            con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod(type);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setConnectTimeout(15000);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "application/octet-stream");
            OutputStream outStream = con.getOutputStream();
            outStream.write(PostData);
            outStream.flush();
            outStream.close();

            int code = con.getResponseCode();
            resultCode = Integer.toString(code);
            
            System.out.println(con.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return resultCode; 
    }

}
