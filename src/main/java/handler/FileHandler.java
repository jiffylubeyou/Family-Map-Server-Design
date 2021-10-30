package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.nio.file.Files;

public class FileHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try
        {
            if (exchange.getRequestMethod().toUpperCase().equals("GET"))
            {
                String urlPath= exchange.getRequestURI().toString();
                if (urlPath.equals("") || urlPath.equals("/"))
                {
                    urlPath = "/index.html";
                }
                String filePath = "web" + urlPath;
                File file = new File(filePath);
                if (file.exists())
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,0);
                    OutputStream respBody = exchange.getResponseBody();
                    Files.copy(file.toPath(), respBody);
                    respBody.close();
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND,0);
                    OutputStream respBody = exchange.getResponseBody();
                    File file1 = new File("web/HTML/404.html");
                    Files.copy((file1.toPath()), respBody);
                    respBody.close();
                }
            }
            else
            {
                // We wanted GET and didn't get it
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson("Error: Bad Request (Command does not exist)"), respBody);
                exchange.getResponseBody().close();
            }
        }
        catch (IOException e)
        {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson("Error: Internal Server Error"), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}
