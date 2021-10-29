package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.ClearResult;
import services.ClearService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

class ClearHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try
        {
            if (exchange.getRequestMethod().toUpperCase().equals("POST"))
            {
                ClearService service =  new ClearService();
                ClearResult result = service.processClear();

                if (result.success)
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    exchange.getResponseBody().close();
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    exchange.getResponseBody().close();
                }
            }
            else
            {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson("Error: Bad request, should be POST"), respBody);
                exchange.getResponseBody().close();
            }
        }
        catch (IOException e)
        {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson("Error: IO Exception"), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}