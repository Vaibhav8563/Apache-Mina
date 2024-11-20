package publisherServer;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.core.service.IoHandlerAdapter;

import java.net.InetSocketAddress;

public class Publisher {

    public static void main(String[] args) {
   		// Create a socket acceptor for the server
        IoAcceptor acceptor = new NioSocketAcceptor(); 
        
        // Set up codec (for text messages)
        acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        
        // Set the handler for managing incoming connections
        acceptor.setHandler(new PublisherHandler());
        
        try {
            // Bind to port 9123
            acceptor.bind(new InetSocketAddress(9123));
            System.out.println("Server started on port 9123...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for processing messages from the client
    static class PublisherHandler extends IoHandlerAdapter {

        @Override
        public void messageReceived(IoSession session, Object message) {
            System.out.println("Received message: " + message);
            // Respond back to the client
            session.write("Message received: " + message);
        }

        @Override
        public void sessionOpened(IoSession session) {
            System.out.println("Session opened: " + session.getRemoteAddress());
        }

        @Override
        public void sessionClosed(IoSession session) {
            System.out.println("Session closed: " + session.getRemoteAddress());
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

