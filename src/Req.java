import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class Req {
	public static String excutePost(String targetURL) {
		URL url;
		HttpURLConnection connection = null;
		try {
			// Create connection
			url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			// connection.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded");

			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);

			Map<String, Object> params = new LinkedHashMap<>();
			params.put("dc.title[]", "Freddie the Fish");
			params.put("dc.title[]", "fishie@seamail.example.com");
			params.put("dc.title[]", 10394);
			params.put(
					"dc.title[]",
					"Shark attacks in Botany Bay have gotten out of control. We need more defensive dolphins to protect the schools here, but Mayor Porpoise is too busy stuffing his snout with lobsters. He's so shellfish.");

			StringBuilder postData = new StringBuilder();
			// for (Map.Entry<String, Object> param : params.entrySet()) {
			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode("dc.title[]", "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(
					String.valueOf("Freddie the Fish"), "UTF-8"));

			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode("dc.title[]", "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(
					String.valueOf("Freddie the Fish"), "UTF-8"));

			if (postData.length() != 0)
				postData.append('&');
			postData.append(URLEncoder.encode("dc.title[]", "UTF-8"));
			postData.append('=');
			postData.append(URLEncoder.encode(
					String.valueOf("Freddie the Fish"), "UTF-8"));
			// }
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			connection.setRequestProperty("Content-Length",
					String.valueOf(postDataBytes.length));
			connection.setDoOutput(true);
			connection.getOutputStream().write(postDataBytes);

			// Send request
			// DataOutputStream wr = new DataOutputStream(
			// connection.getOutputStream());
			//
			// wr.writeBytes(urlParameters);
			// wr.flush();
			// wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {

			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		excutePost("http://10.17.250.250/services/checkItem");
		System.exit(0);
		// URL url = new URL("http://www.java2s.com");
		URL url = new URL("http://10.17.250.250/services/checkItem");
		URLConnection conn = url.openConnection();
		conn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(
				conn.getOutputStream());

		// writer.write("value=1&anotherValue=1");
		writer.write("dc.title[]=ananda");
		// writer.write("dc.title[]:xyz");
		writer.write("dc.language.iso[]=qqq");

		writer.flush();
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		StringBuilder content = new StringBuilder();

		while ((line = reader.readLine()) != null) {
			System.out.println(line);
			content.append(line);
		}
		Object obj = JSONValue.parse(content.toString());
		// JSONArray finalResult=(JSONArray)obj;
		// System.out.println(obj);
		writer.close();
		reader.close();

	}

}
