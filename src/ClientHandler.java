import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class ClientHandler implements Runnable{

    private final Socket socket;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        out.println("\nClientHandlerStarted for " + this.socket);
        handleRequest(this.socket);
        out.println("ClientHandlerTerminated for " + this.socket + "\n");
    }

        public void handleRequest(Socket socket) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
                String headerLine = in.readLine();
                StringTokenizer tokenizer = new StringTokenizer(headerLine);
                String httpMethod = tokenizer.nextToken();
                if (httpMethod.equals("GET")) {
                    out.println("Get methodprocessed");
                            String httpQueryString = tokenizer.nextToken();
                    StringBuilder responseBuffer = new StringBuilder();
                    responseBuffer
                            .append("<html><h1>WebServer HomePage.... </h1><br><b>Welcome to my web server!</b><BR></html>");
                    sendResponse(socket, 200, responseBuffer.toString());
                } else {
                    out.println("The HTTP method is not recognized");
                            sendResponse(socket, 405, "Method Not Allowed");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        public void sendResponse(Socket socket, int statusCode, String responseString) {
            String statusLine;
            String serverHeader = "Server:WebServer\r\n";
            String contentTypeHeader = "Content-Type:text/html\r\n";
            try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {out.close();}
            catch (IOException ex) {
                // Handle exception
            }
            if (statusCode == 200) {
                statusLine = "HTTP/1.0 200 OK" + "\r\n";
                String contentLengthHeader = "ContentLength: " + responseString.length() + "\r\n";
                out.writeBytes(statusLine.getBytes());
                out.writeBytes(serverHeader.getBytes());
                out.writeBytes(contentTypeHeader.getBytes());
                out.writeBytes(contentLengthHeader.getBytes());
                out.writeBytes("\r\n".getBytes());
                out.writeBytes(responseString.getBytes());
            } else if (statusCode == 405) {statusLine = "HTTP/1.0 405 Method Not Allowed" + "\r\n";
                out.writeBytes(statusLine.getBytes());
                out.writeBytes("\r\n".getBytes());
            } else {
                statusLine = "HTTP/1.0 404 Not Found" +
                        "\r\n";
                out.writeBytes(statusLine.getBytes());
                out.writeBytes("\r\n".getBytes());
            }
        }
    }




