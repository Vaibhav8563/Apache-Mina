package ContinuousChat;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.core.service.IoHandlerAdapter;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

public class Publisher {

    // To store active client sessions
    private static final Map<Long, IoSession> sessions = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        IoAcceptor acceptor = new NioSocketAcceptor();
        
        // Set up codec (for text messages)
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        
        // Set the handler for managing incoming connections
        acceptor.setHandler(new PublisherHandler());
        
        try {
            // Bind to port 9123
            acceptor.bind(new InetSocketAddress(9123));
            System.out.println("Server started on port 9123...");

            // Server input to send messages to all clients
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter message to send to clients (type 'exit' to quit): ");
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Shutting down the server...");
                    acceptor.dispose();
                    break;
                }
                // Send the message to all connected clients
                for (IoSession session : sessions.values()) {
                    if (session.isConnected()) {
                        session.write("Server: " + message);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for processing messages from the client
    static class PublisherHandler extends IoHandlerAdapter {

        @Override
        public void sessionOpened(IoSession session) {
            System.out.println("Session opened: " + session.getRemoteAddress());
            sessions.put(session.getId(), session); // Add session to the map
        }

        @Override
        public void sessionClosed(IoSession session) {
            System.out.println("Session closed: " + session.getRemoteAddress());
            sessions.remove(session.getId()); // Remove session from the map
        }

        @Override
        public void messageReceived(IoSession session, Object message) {
            System.out.println("Received message: " + message);
            // Echo the message back to the client
            session.write("Echo: " + message);
        }
    }
}
