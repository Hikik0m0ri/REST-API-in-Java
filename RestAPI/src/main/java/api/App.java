package api;

import spark.Spark;

import static spark.Spark.*;

public class App {
    public static final String JSON_MIME_TYPE = "application/json";
    public static final String SERVER_HOST = "127.0.0.1";
    public static final int SERVER_PORT = 8808;

    public static void main(String[] args) {
        // server config
        ipAddress(SERVER_HOST);
        port(SERVER_PORT);

        //routs
        after((request, response) -> {
            response.type(JSON_MIME_TYPE);
        });

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run(){
                //stop server
                Spark.stop();
            }
        });
    }
}
