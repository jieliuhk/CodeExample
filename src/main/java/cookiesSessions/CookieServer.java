package cookiesSessions;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlets.CrossOriginFilter;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 * Modified from the example of Prof. Engle.
 *
 * @see CookieBaseServlet
 * @see CookieVisitsServlet
 * @see CookieConfigServlet
 */
public class CookieServer {
	public final static int PORT = 8090;
	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		FilterHolder filterHolder = new FilterHolder(CrossOriginFilter.class);
		filterHolder.setInitParameter("allowedOrigins", "*");
		filterHolder.setInitParameter("allowedMethods", "GET, POST");

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(CookieVisitsServlet.class, "/display");
		handler.addServlet(CookieConfigServlet.class, "/clear");
		handler.addFilter(filterHolder, "/*", null);

		server.setHandler(handler);
		//server.setHandler(clearCookieHandler);
		server.start();
		server.join();
	}
}