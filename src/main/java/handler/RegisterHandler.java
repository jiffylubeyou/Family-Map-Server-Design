package handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import requestresponse.LoginRequest;
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
                //now that register is finished, call login
                if (result.success)
                {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setDataFromRegister(result.username, result.password);
                    LoginService loginService = new LoginService(loginRequest);
                    LoginResult loginResult = loginService.processLogin();
                    if (loginResult.success)
                    {
                        exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                        OutputStream respBody = exchange.getResponseBody();
                        WriteString.writeString(GsonSerializer.toJson(loginResult), respBody);
                        respBody.close();
                    }
                    else
                    {
                        exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                        OutputStream respBody = exchange.getResponseBody();
                        WriteString.writeString(GsonSerializer.toJson(loginResult), respBody);
                        respBody.close();
                    }
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
                WriteString.writeString(GsonSerializer.toJson(new RegisterResult(null,null,null,
                        "Error: Bad request, should be POST", false)), respBody);
                exchange.getResponseBody().close();
            }
        } catch
        (IOException e) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson(new RegisterResult(null,null,null,
                    "Error: IO Exception", false)), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}

