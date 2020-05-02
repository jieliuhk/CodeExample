package cookiesSessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Demonstrates how to create, use, and clear cookies. Vulnerable to attack
 * since cookie values are not sanitized prior to use!
 * Modified from the example of Prof. Engle
 * @see CookieBaseServlet
 * @see CookieConfigServlet
 */
@SuppressWarnings("serial")
public class CookieConfigServlet extends CookieBaseServlet {

	public static final String VISIT_DATE = "Visited";
	public static final String VISIT_COUNT = "Count";

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		prepareResponse("Config", response);

		Map<String, String> cookies = getCookieMap(request);

		String visitDate = cookies.get(VISIT_DATE);
		String visitCount = cookies.get(VISIT_COUNT);

		PrintWriter out = response.getWriter();
		out.printf("<p>");

		// Update visit count as necessary and output information.
		if ((visitDate == null) || (visitCount == null)) {
			visitCount = "0";

			out.println("You have never been to this webpage before! ");
			out.println("Not Allow to clear cookies!");
		}
		else {
			out.println("<p>To clear saved cookies, please press \"Clear\".</p>");
			out.println();

			out.println("<form method=\"post\" action=\"" + request.getRequestURI() + " \">");
			out.println("\t<input type=\"submit\" value=\"Clear\">");
			out.println("</form>");
		}

		out.println("</p>");
		finishResponse(request, response);
	}

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {


		clearCookies(request, response);

		prepareResponse("Configure", response);

		PrintWriter out = response.getWriter();
		out.printf("<p>Your cookies for this site have been cleared.</p>%n%n");

		finishResponse(request, response);
	}
}