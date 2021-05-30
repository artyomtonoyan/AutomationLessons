package utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

import static utilities.DateAndTimeHelper.getCurrentDateAndTime;
import static utilities.FileHelper.write;

public class ApiHelper {
    private static final String GENERATED_TEXT = UUID.randomUUID().toString();
    private static final String PASSWORD = "Test!!8493.";
    private static final Logger LOGGER = Logger.getLogger(ApiHelper.class);

    public static JsonObject createUser() throws IOException {
        try {
            String message = "Creating new user: Email: " + GENERATED_TEXT + "@gmail.com, Password: " + PASSWORD;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"email\": \"" + GENERATED_TEXT + "@gmail.com\",\n\t\"password\": \"" + PASSWORD + "\"\n}");
        Request request = new Request.Builder()
                .url("https://picsart.com/sign-up")
                .method("POST", body)
                .addHeader("authority", "picsart.com")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static JsonObject uploadPhoto(String key) throws IOException {
        try {
            String message = "Uploading new photo in the user profile: " + key;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType.parse("application/json");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("type", "photo")
                .addFormDataPart("file", "mytest.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/Users/artyomtonoyan/AutomationHomeworks/src/main/resources/mytest.jpg")))
                .addFormDataPart("is_public", "1")
                .addFormDataPart("tags", "freetoedit")
                .addFormDataPart("tags", "firstTimeUploadTest")
                .build();
        Request request = new Request.Builder()
                .url("https://api.picsart.com/stage/photos/add.json?key=" + key + "&is_public=1")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("is_public", "1")
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static JsonObject addHashtagToExistingPhoto(String photoId, String key, String... hashtags) throws IOException {
        try {
            String message = "Adding the following hashtags: " + Arrays.toString(hashtags) + " to the following users: " + key + " photo: " + photoId;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        StringBuilder addingHashtags;
        addingHashtags = new StringBuilder();
        for (String hashtag : hashtags) {
            addingHashtags.append(hashtag);
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"id\":" + photoId + ",\n\t\"title\": \"" + addingHashtags + "\",\n\t\"is_public\": 1,\n\t\"location_place\": \"\",\n\t\"location_lat\": \"\",\n\t\"location_lon\": \"\"\n}");
        Request request = new Request.Builder()
                .url("https://api.picsart.com/stage/photos/update/" + photoId + ".json?key=" + key)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static JsonObject deleteUser(String key) throws IOException {
        try {
            String message = "Deleting the user: " + key;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.picsart.com/stage/users/remove?key=" + key)
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        String json = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(json).getAsJsonObject();
    }

    public static JsonObject likePhoto(String userKey, String imageId) throws IOException {
        try {
            String message = "Liking the photo:  " + imageId + " of the following user: " + userKey;
            LOGGER.info(message);
            write("src/files/logs.txt", "\n" + getCurrentDateAndTime() + ": " + message);
        } catch (IOException e) {
            LOGGER.error("File not found / Can't write: Current log can't be saved");
        }
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.picsart.com/preproduction/photos/likes/add/" + imageId + ".json?key=" + userKey)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = Objects.requireNonNull(response.body()).string();
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }
}