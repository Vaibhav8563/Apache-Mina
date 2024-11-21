package ContinuousChat;

import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        IoConnector connector = new NioSocketConnector();
        
        // Set up codec (for text messages)
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        
        // Set the handler to process the server's responses
        connector.setHandler(new ClientHandler());
        
        try {
            // Connect to the server on localhost, port 9123
            IoSession session = connector.connect(new InetSocketAddress("localhost", 9123)).awaitUninterruptibly().getSession();
            
            // Continue sending messages until the session is disconnected or the user enters 'exit'
            Scanner scanner = new Scanner(System.in);
            String message;
            while (session.isConnected()) { // Correct method to check session status
                System.out.print("Enter message (type 'exit' to quit): ");
                message = scanner.nextLine();
                
                if ("exit".equalsIgnoreCase(message)) {
                    session.closeNow();  // Close the session gracefully if the user types 'exit'
                    break;
                }
                
                // Send the message to the server
                session.write(message);
            }
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

        @Override
        public void sessionClosed(IoSession session) {
            System.out.println("Session closed, exiting client...");
        }
    }
}
