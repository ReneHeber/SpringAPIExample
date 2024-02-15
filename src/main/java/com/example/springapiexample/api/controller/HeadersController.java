package com.example.springapiexample.api.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/headers")
public class HeadersController {

    private final Map<String, String> tokens = new HashMap<>();

    @GetMapping
    public ResponseEntity getToken(HttpServletResponse response) {
        String token = UUID.randomUUID().toString();
        String time = System.currentTimeMillis() + "";
        tokens.put(token, time);
        // what is this part doing exactly?
        response.addCookie(new Cookie("time", time));
        return ResponseEntity.ok().body(token);
    }

    @GetMapping("/{token:.+}")
    public ResponseEntity validateToken(@CookieValue("time") String time,
                                        @RequestHeader("Authorization") String[] authorization,
                                        @PathVariable String token,
                                        @RequestParam String url) {
        String temp = tokens.get(token);
        String auth = authorization[0];
        if (auth.equals("dummy")) {
            auth = authorization[1];
        }
        if (temp.equals(time) && auth.equals(token + time + url)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
