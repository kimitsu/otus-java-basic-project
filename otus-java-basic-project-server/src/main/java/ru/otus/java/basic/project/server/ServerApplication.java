package ru.otus.java.basic.project.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ServerApplication {
    private static final Logger log = LogManager.getLogger(ServerApplication.class);
    private static final int DEFAULT_PORT = 35555;

    public static void main(String[] args) {
        Server server;
        try {
            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
            server = new Server(port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                log.info("Shutdown signal received");
                server.close();

                // TODO Check if all sockets are closed
            }));
            server.start();
        } catch (NumberFormatException e) {
            log.fatal("Invalid port number");
        } catch (IOException e) {
            log.fatal("Server socket error", e);
        }
        // TODO Ensure we reach this on Ctrl-C
        log.trace("Server stopped");
    }
}
