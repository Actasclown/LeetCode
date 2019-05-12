package com.aac.q0535.encodeanddecodetinyurl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by He at 11:22 2019/5/11
 */
public class Codec {
    private Map<Long, String> dictionary = new HashMap<>();
    private static long num = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        dictionary.put(num, longUrl);
        return String.valueOf(num++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dictionary.get(Long.valueOf(shortUrl));
    }

    public static void main(String[] args) {
        Codec test = new Codec();
        test.encode("www.cctv.com");
        System.out.println(test.decode("0"));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));