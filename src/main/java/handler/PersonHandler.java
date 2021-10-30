package handler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dao.AuthTokenDao;
import dao.DataAccessException;
import dao.Database;
import requestresponse.*;
import services.PersonService;
import services.PersonServiceArray;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.sql.Connection;

class PersonHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try {
            if (exchange.getRequestMethod().toUpperCase().equals("GET")) {
                Headers reqHeaders = exchange.getRequestHeaders();

                if (reqHeaders.containsKey("Authorization")) {

                    String authToken = reqHeaders.getFirst("Authorization");

                    Database database = new Database();
                    String username = null;
                    try
                    {
                        Connection conn = database.getConnection();
                        AuthTokenDao dao = new AuthTokenDao(conn);
                        username = dao.find(authToken);
                        database.closeConnection(true);
                    }
                    catch (DataAccessException e)
                    {
                        try {
                            database.closeConnection(false);
                            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                            OutputStream respBody = exchange.getResponseBody();
                            WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                                    null,null,null,null,null,null,
                                    "Error: " + e.getMessage(), false)), respBody);
                            exchange.getResponseBody().close();
                        }
                        catch (DataAccessException ex)
                        {
                            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                            OutputStream respBody = exchange.getResponseBody();
                            WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                                    null,null,null,null,null,null,
                                    "Error: " + ex.getMessage(), false)), respBody);
                            exchange.getResponseBody().close();
                        }
                    }
                    if (username != null) {

                        //authtoken has been checked
                        String urlPath = exchange.getRequestURI().toString();
                        String[] strings = urlPath.split("/");

                        PersonRequest request = new PersonRequest(username);
                        if (strings.length > 2) {
                            String personID = strings[2];
                            request.setPersonID(personID);
                            PersonService service = new PersonService(request);
                            PersonResult result = service.processPerson();

                            if (result.success) {
                                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                                OutputStream respBody = exchange.getResponseBody();
                                WriteString.writeString(GsonSerializer.toJson(result), respBody);
                                respBody.close();
                            } else {
                                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                                OutputStream respBody = exchange.getResponseBody();
                                WriteString.writeString(GsonSerializer.toJson(result), respBody);
                                respBody.close();
                            }
                        }
                        else
                        {
                            PersonServiceArray service = new PersonServiceArray(request);
                            PersonResultArray result = service.processPersonArray();
                            if (result.success) {
                                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
                                OutputStream respBody = exchange.getResponseBody();
                                WriteString.writeString(GsonSerializer.toJson(result), respBody);
                                respBody.close();
                            } else {
                                exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
                                OutputStream respBody = exchange.getResponseBody();
                                WriteString.writeString(GsonSerializer.toJson(result), respBody);
                                respBody.close();
                            }
                        }
                    }
                    else
                    {
                        exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                        OutputStream respBody = exchange.getResponseBody();
                        WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                                null,null,null,null,null,null,
                                "Error: Unauthorized to access", false)), respBody);
                        exchange.getResponseBody().close();
                    }
                }
                else
                {
                    exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                    OutputStream respBody = exchange.getResponseBody();
                    WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                            null,null,null,null,null,null,
                            "Error: Bad request, no authorization key", false)), respBody);
                    exchange.getResponseBody().close();
                }
            }
            else
            {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                OutputStream respBody = exchange.getResponseBody();
                WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                        null,null,null,null,null,null,
                        "Error: Bad request, should be POST", false)), respBody);
                exchange.getResponseBody().close();
            }
        }
        catch (IOException e)
        {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            OutputStream respBody = exchange.getResponseBody();
            WriteString.writeString(GsonSerializer.toJson(new PersonResult(null,null,
                    null,null,null,null,null,null,
                    "Error: IO Exception", false)), respBody);
            exchange.getResponseBody().close();

            e.printStackTrace();
        }
    }
}
