package com.itcen.tellcen.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.itcen.tellcen.domain.TopicInfoDTO;

@Service
public class RestFulService {

	public List<TopicInfoDTO> getTopicInfo() throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		String Today = sdf.format(cal.getTime());

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1140100/minAnalsInfoView2/minTodayTopicInfo2"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=TecYJ%2BZ%2BNTVipDkwhgiYoM43DJdXAI0NpPupWOu5hwim1AFEyZn10mb7NCIxAHRswHTTVVEUfBl8KZ6vZDM9aA%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder.append("&" + URLEncoder.encode("searchDate", "UTF-8") + "="
				+ URLEncoder.encode(Today, "UTF-8")); /* 오늘 날짜 */
		urlBuilder.append("&" + URLEncoder.encode("todayTopicTopN", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); /* 총 topic 수 */
		urlBuilder.append("&" + URLEncoder.encode("arget", "UTF-8") + "="
				+ URLEncoder.encode("pttn,dfpt,saeol", "UTF-8")); /* 문서 참조 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		ObjectMapper mapper = new ObjectMapper();

		List<TopicInfoDTO> list = Arrays.asList(mapper.readValue(sb.toString(), TopicInfoDTO[].class));

		System.out.println(list);

		return list;
	}
}
