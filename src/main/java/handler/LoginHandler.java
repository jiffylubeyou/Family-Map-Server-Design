package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.LoginRequest;
import requestresponse.LoginResult;
import services.LoginService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

class LoginHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (exchange.getRequestMethod().toUpperCase().equals("POST")) {
                InputStream reqBody = exchange.getRequestBody();

                String reqData = ReadString.readString(reqBody);
                LoginService service = new LoginService(GsonSerializer.fromJson(reqData, LoginRequest.class));
                LoginResult result = service.processLogin();
                if (result.success)
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(result), respBody);
                    respBody.close();
                }
            } else {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson("Error: Bad request, should be POST"), respBody);
                exchange.getResponseBody().close();
            }
        } catch
        (IOException e) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson("Error: IO Exception"), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}


