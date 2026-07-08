package mcp.amolD;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExternalApi {

    private final HttpClient client = HttpClient.newHttpClient();

    public String getData() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  String getData(int id) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/"+id))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printData(String data){
        System.out.println(data);
    }
}