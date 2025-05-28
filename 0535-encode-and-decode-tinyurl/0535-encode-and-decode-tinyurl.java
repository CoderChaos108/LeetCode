public class Codec {
    HashMap<String,String> hm=new HashMap<>();
    HashMap<String,String> dec=new HashMap<>();
    StringBuilder sb=new StringBuilder();
    public String encode(String longUrl) {
        sb.setLength(0);
        if(hm.containsKey(longUrl))
        return hm.get(longUrl);
        sb.append("http://tinyUrl/");
        int x=hm.size();
        x=x%26;
        x=(int)'a'+x;
        sb.append((char)x);
        sb.append(String.valueOf(hm.size()));
        hm.put(longUrl,sb.toString());
        dec.put(sb.toString(),longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dec.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));