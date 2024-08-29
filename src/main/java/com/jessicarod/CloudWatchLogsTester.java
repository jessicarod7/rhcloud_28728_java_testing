package com.jessicarod;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.commons.text.RandomStringGenerator;


import java.util.Arrays;

@Path("/")
public class CloudWatchLogsTester {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String issueLogs() {
        for (String log: generateLogs()) {
            Log.info(log);
        }

        return "Issued 25000 logs to CloudWatch";
    }

    public String[] generateLogs() {
        RandomStringGenerator generator = RandomStringGenerator.builder().withinRange('0', 'z').get();

        String[] logs = new String[25000];
        return Arrays.stream(logs).map(i -> generator.generate(1024)).toArray(String[]::new);
    }
}
