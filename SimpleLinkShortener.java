import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleLinkShortener {
    private Map<String, String> urlMap;

    public SimpleLinkShortener() {
        this.urlMap = new HashMap<>();
    }

    public String shortenUrl(String originalUrl) {
        String shortKey = generateShortKey(originalUrl);
        String shortenedUrl = "http://your-shortener.com/" + shortKey;

        // Store the mapping in the map
        urlMap.put(shortKey, originalUrl);

        return shortenedUrl;
    }

    public String expandUrl(String shortUrl) {
        String shortKey = extractShortKey(shortUrl);
        return urlMap.getOrDefault(shortKey, "URL not found");
    }

    private String generateShortKey(String originalUrl) {
        // Use a basic hash function (hashCode) for simplicity
        return Integer.toHexString(originalUrl.hashCode());
    }

    private String extractShortKey(String shortUrl) {
        // Extract the short key from the short URL
        String[] parts = shortUrl.split("/");
        return parts[parts.length - 1];
    }

    public static void main(String[] args) {
        SimpleLinkShortener linkShortener = new SimpleLinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the original URL: ");
                    String originalUrl = scanner.nextLine();
                    String shortenedUrl = linkShortener.shortenUrl(originalUrl);
                    System.out.println("Shortened URL: " + shortenedUrl);
                    break;
                case 2:
                    System.out.print("Enter the shortened URL: ");
                    String shortUrl = scanner.nextLine();
                    String expandedUrl = linkShortener.expandUrl(shortUrl);
                    System.out.println("Expanded URL: " + expandedUrl);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
