import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;

public class test {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        HashMap notification = new HashMap();
        HashMap data = new HashMap();
        String[] ids = {"Volvo", "BMW", "Ford", "Mazda"};


        notification.put("body", "Body of Your Notification");
        notification.put("title", "Title of Your Notification");

        data.put("body", "Sending Notification Body From Data");
        data.put("title", "Notification Title from Data");

        HashMap dt = new HashMap();
//        dt.put("to", "e5gBnAyq8zEngjU0X2IJ_mUNiJSwYsrDybeykrPQf29tto0cVmOD7pRQagW3DZBC");
        dt.put("registration_ids", ids);
        dt.put("collapse_key", "type_a");
        dt.put("notification", notification);
        dt.put("data", data);

        Connection connection = Jsoup.connect("https://fcm.googleapis.com/fcm/send")
                .userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36") // User-Agent of Chrome 55
//                .referrer("https://fcm.googleapis.com/fcm/send")
                .ignoreContentType(true)
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("Accept", "text/plain, */*; q=0.01")
                .header("Accept-Encoding", "gzip,deflate,sdch")
                .header("Accept-Language", "es-ES,es;q=0.8")
                .header("Connection", "keep-alive")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("Authorization", "key=ZxcvBNME6JK_SsYJAENDcPkRpWH9NcZ0O")
                .requestBody(gson.toJson(dt))
                .maxBodySize(100)
                .timeout(1000 * 10)
                .method(Connection.Method.POST);

        Connection.Response response = connection.execute();
        System.out.println(response.body());
    }

}
