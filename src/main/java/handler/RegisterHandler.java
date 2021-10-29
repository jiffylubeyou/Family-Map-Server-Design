package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.LoginResult;
import requestresponse.RegisterRequest;
import requestresponse.RegisterResult;
import services.LoginService;
import services.RegisterService;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

class RegisterHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (exchange.getRequestMethod().toUpperCase().equals("POST")) {
                InputStream reqBody = exchange.getRequestBody();

                String reqData = ReadString.readString(reqBody);
                RegisterService service = new RegisterService(GsonSerializer.fromJson(reqData, RegisterRequest.class));

                RegisterResult result = service.processRegister();
                if (result.success)
                {
                    LoginService loginService = new LoginService()
                }

                if (result.success) {
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

