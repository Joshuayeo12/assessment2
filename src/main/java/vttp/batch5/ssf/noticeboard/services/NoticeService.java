package vttp.batch5.ssf.noticeboard.services;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vttp.batch5.ssf.noticeboard.repositories.NoticeRepository;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Date;

@Service
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;

	//	@Autowired
	//	private NoticeRepository noticeRepository;

	// TODO: Task 3
	// You can change the signature of this method by adding any number of parameters
	// and return any type

public static final String GET_URL = "https://publishing-production-d35a.up.railway.app/notice";
	public void postToNoticeServer() {
		RequestEntity<Void> req = RequestEntity
				.get(GET_URL)
				.accept(MediaType.APPLICATION_JSON)
				.build();

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response;
		try {
			response = restTemplate.exchange(req, String.class);
			String payload = response.getBody();
			JsonReader jsonReader = Json.createReader(new StringReader(payload));
			JsonObject jsonObject = jsonReader.readObject();
			String title = jsonObject.getString("Notice title");
			String poster = jsonObject.getString("poster's email");
			Number postDate = (Number) jsonObject.getJsonNumber("date");
			JsonArray categories = jsonObject.getJsonArray("List of categories");
			String text = jsonObject.getString("Notice text");
			System.out.println("Title: " + title);

		} catch (Exception e) {
			e.printStackTrace();
		}




	}
}
