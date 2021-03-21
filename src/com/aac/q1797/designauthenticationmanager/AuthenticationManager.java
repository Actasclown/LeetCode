package com.aac.q1797.designauthenticationmanager;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    Map<String, int[]> tokens;
    int TTL;

    public AuthenticationManager(int timeToLive) {
        this.tokens = new HashMap<>();
        this.TTL = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, new int[] {currentTime, currentTime + TTL - 1});
    }

    public void renew(String tokenId, int currentTime) {
        if(tokens.containsKey(tokenId)) {
            int[] timeSpan = tokens.get(tokenId);
            if(currentTime >= timeSpan[0] && currentTime <= timeSpan[1]) {
                timeSpan[1] = currentTime + TTL - 1;
                System.out.println(tokenId + " " + timeSpan[1]);
            }
            tokens.put(tokenId, timeSpan);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int[] timeSpan : tokens.values()) {
            if(currentTime >= timeSpan[0] && currentTime <= timeSpan[1]) {
                count++;
            }
        }
        System.out.println("At " + currentTime + " , Count = " + count);
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager a = new AuthenticationManager(5);
        a.renew("aaa", 1);
        a.generate("aaa", 2);
        a.countUnexpiredTokens(6);
        a.generate("bbb", 7);
        a.renew("aaa", 8);
        a.renew("bbb", 10);
        a.countUnexpiredTokens(15);
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */