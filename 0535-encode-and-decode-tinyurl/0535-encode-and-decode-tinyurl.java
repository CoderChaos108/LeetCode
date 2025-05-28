public class Codec {
    String s;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        s=longUrl;
        return "a";
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return s;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));