import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

/**
 * Practical 9 - Program 3:
 * Implement a Java URL class for accessing resource information.
 *
 * Demonstrates methods of java.net.URL and java.net.URLConnection:
 *   - getProtocol()
 *   - getHost()
 *   - getPort()
 *   - getDefaultPort()
 *   - getFile()
 *   - getPath()
 *   - getQuery()
 *   - getRef()
 *   - getContentType()
 *   - getContentLength()
 *   - getLastModified() / getDate()
 */
public class URLResourceInfo {

    public static void displayResourceInfo(String urlString) {
        try {
            // Create URL instance
            URL url = new URL(urlString);

            System.out.println("\n----------------- URL Components -----------------");
            System.out.println("Full URL String     : " + url.toExternalForm());
            System.out.println("Protocol            : " + url.getProtocol());
            System.out.println("Host Name           : " + url.getHost());
            System.out.println("Port Specified      : " + (url.getPort() == -1 ? "Default (Not explicit)" : url.getPort()));
            System.out.println("Default Port        : " + url.getDefaultPort());
            System.out.println("File Component      : " + url.getFile());
            System.out.println("Path                : " + url.getPath());
            System.out.println("Query String        : " + (url.getQuery() != null ? url.getQuery() : "None"));
            System.out.println("Reference / Anchor  : " + (url.getRef() != null ? url.getRef() : "None"));

            // Access resource connection details
            System.out.println("\n----------------- Connection Resource Details -----------------");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000); // 5 sec timeout
            connection.connect();

            System.out.println("Content Type        : " + connection.getContentType());
            System.out.println("Content Length      : " + connection.getContentLength() + " bytes");
            System.out.println("Content Encoding    : " + connection.getContentEncoding());
            System.out.println("Date                : " + new Date(connection.getDate()));
            System.out.println("Last Modified       : " + (connection.getLastModified() != 0 ? new Date(connection.getLastModified()) : "Not Specified"));
            System.out.println("Expiration          : " + (connection.getExpiration() != 0 ? new Date(connection.getExpiration()) : "Not Specified"));
            System.out.println("---------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error accessing URL resource: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" Practical 9.3: Java URL Resource Information     ");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter URL (or press Enter for default 'https://www.google.com/search?q=java#top'): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                input = "https://www.google.com/search?q=java#top";
            }

            // Ensure protocol is present
            if (!input.startsWith("http://") && !input.startsWith("https://")) {
                input = "https://" + input;
            }

            displayResourceInfo(input);

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
