package clientServer;


import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.apache.mina.core.service.IoHandlerAdapter;

import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

import org.apache.mina.filter.codec.ProtocolCodecFilter;

import java.net.InetSocketAddress;

public class Client {

    public static void main(String[] args) {
    	// Create a socket connector for the client
        IoConnector connector = new NioSocketConnector();
        
        // Set up codec (for text messages)
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        
        // Set the handler to process the server's responses
        connector.setHandler(new ClientHandler());
        
        try {
            // Connect to the server on localhost, port 9123
            IoSession session = connector.connect(new InetSocketAddress("localhost", 9123)).awaitUninterruptibly().getSession();
            
            // Send a message to the server
            session.write("Hello from the client!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for processing server responses
    static class ClientHandler extends IoHandlerAdapter {

        @Override
        public void messageReceived(IoSession session, Object message) {
            System.out.println("Received from server: " + message);
        }

        @Override
        public void exceptionCaught(IoSession session, Throwable cause) {
            cause.printStackTrace();
        }
    }
}




/*

Current Flow:
	Step 1. The Publisher starts listening on port 9123.
	Step 2. The Client connects to the Publisher and sends a message.
	Step 3. The Publisher receives the message and responds with a confirmation.
	Step 4. The Client prints the response.
	Step 5. The process stops after one round of message exchange.

*/
