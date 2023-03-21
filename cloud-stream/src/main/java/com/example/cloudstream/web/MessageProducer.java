package com.example.cloudstream.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MessageProducer {

    StreamBridge streamBridge;

    @PostMapping("/msg")
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        streamBridge.send("producer-out-0", message);
        return ResponseEntity.ok("Message sent");
    }
}
