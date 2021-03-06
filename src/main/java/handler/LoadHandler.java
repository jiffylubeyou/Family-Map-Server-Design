package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.*;
import services.ClearService;
import services.LoadService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

class LoadHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (exchange.getRequestMethod().toUpperCase().equals("POST")) {

                InputStream reqBody = exchange.getRequestBody();

                //clear tables first
                ClearService clearService = new ClearService();
                clearService.processClear();

                String reqData = ReadString.readString(reqBody);
                LoadService service = new LoadService(GsonSerializer.fromJson(reqData, LoadRequest.class));
                LoadResult result = service.processLoad();

                if (result.success)
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
            } else {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson(new LoadResult(
                        "Error: Bad request, should be POST", false)), respBody);
                exchange.getResponseBody().close();
            }
        } catch
        (IOException e) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson(new LoadResult(
                    "Error: IO Exception", false)), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}


