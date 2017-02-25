package com.tvelykyy.mm.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
public class WorkerController {
    private static final Logger LOG = LoggerFactory.getLogger(WorkerController.class);

    @PostMapping("process")
    @ResponseBody
    public int process() {
        LOG.info("Processing heavy job...");
        int waitMilliseconds = calculateWaitingTime();

        try {
            TimeUnit.MILLISECONDS.sleep(waitMilliseconds);
        } catch (InterruptedException e) {
            LOG.error("Thread processing heavy job has been interrupted.");
        }

        LOG.info("Heavy job processing in: {} milliseconds", waitMilliseconds);
        return waitMilliseconds;
    }

    private int calculateWaitingTime() {
        //Wait for some additional time from 0 to 2000 milliseconds
        int additionalMilliseconds = (int) (Math.random() * 2000);

        return 1000 + additionalMilliseconds;
    }
}
