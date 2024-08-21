import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class NoGovernmentCookies implements CookiePolicy {

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        String authority = uri.getAuthority();
        if (authority != null && authority.toLowerCase().endsWith(".gov")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example URIs to test with
        URI uri1 = URI.create("http://example.com");
        URI uri2 = URI.create("http://www.usa.gov");
        URI uri3 = URI.create("https://www.nasa.gov");

        NoGovernmentCookies cookiePolicy = new NoGovernmentCookies();

        // Test case 1: example.com (should accept)
        System.out.println("Should accept cookie for " + uri1 + ": " + cookiePolicy.shouldAccept(uri1, null));

        // Test case 2: usa.gov (should not accept)
        System.out.println("Should accept cookie for " + uri2 + ": " + cookiePolicy.shouldAccept(uri2, null));

        // Test case 3: nasa.gov (should not accept)
        System.out.println("Should accept cookie for " + uri3 + ": " + cookiePolicy.shouldAccept(uri3, null));
    }
}
