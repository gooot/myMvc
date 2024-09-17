package com.gooot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gooot.calculate.Calculator;
import com.gooot.calculate.HttpResponse;
import com.gooot.calculate.PositiveNumber;

public class CustomWebApplicationServer {

	private final int port;

	private final ExecutorService executor = Executors.newFixedThreadPool(10);

	private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

	public CustomWebApplicationServer(int port) {
		this.port = port;
	}

	public void start() throws IOException {

		try (ServerSocket serverSocket = new ServerSocket(port)) {
			logger.info("[CustomWebApplicationServer] started {} port", port);

			Socket clientSocket;
			logger.info("[CustomWebApplicationServer] waiting for client connection");

			while((clientSocket = serverSocket.accept()) != null) {
				logger.info("[CustomWebApplicationServer] client connected");



				executor.execute(new ClientRequestHandler(clientSocket));

				// new Thread(new ClientRequestHandler(clientSocket)).start();
			}



		}

	}
}
