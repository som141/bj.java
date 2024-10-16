package apiC;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.opencsv.CSVWriter;
import org.json.JSONArray;
import org.json.JSONObject;

public class api1 {
    public static void main(String[] args) {
        try {
            // API 호출
            String apiUrl = "https://kr.api.riotgames.com/lol/league/v4/masterleagues/by-queue/RANKED_SOLO_5x5?api_key=YOUR_API_KEY";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // JSON 파싱
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray entries = jsonResponse.getJSONArray("entries");

            // CSV 파일 작성
            FileWriter fileWriter = new FileWriter("riot_data.csv");
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] header = {"Summoner Name", "Summoner ID"};
            csvWriter.writeNext(header);

            // 데이터 저장
            for (int i = 0; i < entries.length(); i++) {
                JSONObject summoner = entries.getJSONObject(i);
                String summonerName = summoner.getString("summonerName");
                String summonerId = summoner.getString("summonerId");
                String[] data = {summonerName, summonerId};
                csvWriter.writeNext(data);
            }

            csvWriter.close();
            System.out.println("Data saved to CSV");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}