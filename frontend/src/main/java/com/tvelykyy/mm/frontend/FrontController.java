package com.tvelykyy.mm.frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontController {
    private static final Logger LOG = LoggerFactory.getLogger(FrontController.class);

    private RestTemplate restTemplate;

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        LOG.debug("Handling request");
        ResponseEntity<Integer> response =
            restTemplate.exchange("http://worker/process", HttpMethod.POST, null, Integer.class);

        String message = String.format("Requested processed in %s ms", response.getBody().toString());
        LOG.info(message);
        return message;
    }

    @Autowired
    public void setRestTemplate(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
