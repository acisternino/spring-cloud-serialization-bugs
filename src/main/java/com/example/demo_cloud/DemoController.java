package com.example.demo_cloud;

import com.example.demo_cloud.domain.AnnotatedInstantThrows;
import com.example.demo_cloud.domain.StringVsTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller()
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    private final StreamBridge streamBridge;

    public DemoController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping("/string-vs-timestamp")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendDomainObjectDate() {

        log.info("sending a StringVsTimestamp");

        var domObj = new StringVsTimestamp();
        Message<StringVsTimestamp> payload = MessageBuilder.withPayload(domObj)
                .setHeader("type", "StringVsTimestamp")
                .build();

        log.info("payload: {}", payload);

        streamBridge.send("testError-out-0", payload);
    }

    @PostMapping("/instant-throws")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendDomainObjectInstant() {

        log.info("sending an InstantThrows");

        var domObj = new AnnotatedInstantThrows();
        Message<AnnotatedInstantThrows> payload =
                MessageBuilder.withPayload(domObj).setHeader("type", "instant").build();

        log.info("payload: {}", payload);

        streamBridge.send("testError-out-0", payload);
    }
}
