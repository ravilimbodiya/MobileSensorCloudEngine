package com.cloud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.cloud.entity.VirtualSensorData;

public class SensorDataService implements SensorData {

	public SensorDataService() {
	}

	@Override
	public VirtualSensorData getSensorDataFromWebService(Integer vsId) throws Exception {
		URL url = new URL("http://52.53.230.204:8080/sensorData?sensorId="+vsId);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		VirtualSensorData vsd = new VirtualSensorData();
		try {

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			/*System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}*/
			output=br.readLine();
			
			JSONObject json = (JSONObject)new JSONParser().parse(output);
			
			vsd.setSensorId(vsId);
			vsd.setSensorName((String) json.get("sensorName"));
			Timestamp ts = new Timestamp((long) json.get("captureDateTime"));
			vsd.setCaptureDateTime(ts);
			Double uvIndex = (Double) json.get("uvIndex");
			vsd.setUvIndex(uvIndex);
			
			if(uvIndex >= 0 && uvIndex <= 2.9){
				vsd.setRisk("Low");
				vsd.setRiskColor("green");
				vsd.setSuggestionMessage("Wear sunglasses on bright days; use sunscreen if there is snow on the ground, which reflects UV radiation, or if you have particularly fair skin.");
			}
			if(uvIndex >= 3 && uvIndex <= 5.9){
				vsd.setRisk("Moderate");
				vsd.setRiskColor("yellow");
				vsd.setSuggestionMessage("Take precautions, such as covering up, if you will be outside. Stay in shade near midday when the sun is strongest.");
			}
			if(uvIndex >= 6 && uvIndex <= 7.9){
				vsd.setRisk("High");
				vsd.setRiskColor("orange");
				vsd.setSuggestionMessage("Cover the body with sun protective clothing, use SPF 30+ sunscreen, wear a hat, reduce time in the sun within three hours of solar noon, and wear sunglasses.");
			}
			if(uvIndex >= 8 && uvIndex <= 10.9){
				vsd.setRisk("Very High");
				vsd.setRiskColor("red");
				vsd.setSuggestionMessage("Wear SPF 30+ sunscreen, a shirt, sunglasses, and a wide-brimmed hat. Do not stay in the sun for too long.");
			}
			if(uvIndex >= 11){
				vsd.setRisk("Extreme");
				vsd.setRiskColor("violet");
				vsd.setSuggestionMessage("Take all precautions: Wear SPF 30+ sunscreen, a long-sleeved shirt and trousers, sunglasses, and a very broad hat. Avoid the sun within three hours of solar noon.");
			}
			
			System.out.println("name=" + json.get("sensorId"));
			System.out.println("width=" + json.get("sensorName"));

		} catch (MalformedURLException e) {

			e.printStackTrace();
			throw new Exception(e);

		} catch (IOException e) {

			e.printStackTrace();
			throw new Exception(e);

		} finally {
			conn.disconnect();
		}
		return vsd;
	}

}
