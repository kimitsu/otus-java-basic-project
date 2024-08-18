package ru.otus.java.basic.project.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ServerApplication {
    private static final Logger log = LogManager.getLogger(ServerApplication.class);
    private static final int DEFAULT_PORT = 35555;

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Server server;
        try {
            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
            server = new Server(port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                synchronized (mainThread) {
                    log.info("Shutdown signal received");
                    server.close();
                    try {
                        mainThread.wait();
                    } catch (InterruptedException e) {
                        log.error("Thread interrupted", e);
                    }
                    log.trace("Shutdown complete");
                    LogManager.shutdown(false, true);
                }
            }));
            server.start();
        } catch (NumberFormatException e) {
            log.fatal("Invalid port number");
        } catch (IOException e) {
            log.fatal("Server socket error", e);
        }
        log.info("Server stopped");
        synchronized (mainThread) {
            mainThread.notifyAll();
        }
    }
}
