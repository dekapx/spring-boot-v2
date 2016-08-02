package com.dimensiondata.cloud.android.sender;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

@SuppressWarnings("serial")
public class GcmSender implements Serializable {

	public static final String API_KEY = "AIzaSyDlpBY9a6IasnaSKrAkJFox9bodZ90v_4M";

	public void sendMessage(final String title, final String message) {
		try {
			final JSONObject jGcmData = new JSONObject();
			final JSONObject jData = new JSONObject();
			jData.put("title", title);
			jData.put("message", message);
			jGcmData.put("to", "/topics/global");
			// What to send in GCM message.
			jGcmData.put("data", jData);

			// Create connection to send GCM Message request.
			final URL url = new URL("https://android.googleapis.com/gcm/send");
			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "key=" + API_KEY);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// Send GCM message content.
			final OutputStream outputStream = conn.getOutputStream();
			outputStream.write(jGcmData.toString().getBytes());

			// Read GCM response.
			final InputStream inputStream = conn.getInputStream();
			String resp = IOUtils.toString(inputStream);
			System.out.println(resp);
			System.out.println("Check your device/emulator for notification or logcat for " + "confirmation of the receipt of the GCM message.");
		} catch (IOException e) {
			System.out.println("Unable to send GCM message.");
			System.out.println("Please ensure that API_KEY has been replaced by the server " + "API key, and that the device's registration token is correct (if specified).");
			e.printStackTrace();
		}
	}
}
