package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.FillResult;
import services.FillService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

class FillHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (exchange.getRequestMethod().toUpperCase().equals("POST")) {

                String urlPath= exchange.getRequestURI().toString();
                String[] strings = urlPath.split("/");
                String username = strings[2];
                int generations;
                if (strings.length > 3)
                {
                    generations = Integer.parseInt(strings[3]);
                }
                else
                {
                    generations = 4;
                }
                FillService service = new FillService(username, generations);
                FillResult result = service.processFill();
                if (result.success)
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_UNAUTHORIZED, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
            } else {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson(new FillResult(
                        "Error: Bad request, should be POST", false)), respBody);
                exchange.getResponseBody().close();
            }
        } catch
        (IOException e) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson(new FillResult(
                    "Error: IO Exception", false)), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}


