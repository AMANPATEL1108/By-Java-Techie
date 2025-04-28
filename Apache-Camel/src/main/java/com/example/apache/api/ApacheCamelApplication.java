package com.example.apache.api;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApacheCamelApplication extends RouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(ApacheCamelApplication.class, args);
    }

    @Override
    public void configure() throws Exception {

        //move data from oen file to another file
        System.out.println("Started");

//		from("file:C:/Users/amanp/OneDrive/Desktop/a?noop=true").to("file:C:/Users/amanp/OneDrive/Desktop/b");
//			moveAllFile();
//		moveSpecificFile("file1");

//        moveSpecificFileWithBody("Aman Patel");
//        fileProcess();
        multiFileProcessor();
        System.out.println("ENded");
    }

    public void moveSpecificFile(String type) {
        from("file:C:/Users/amanp/OneDrive/Desktop/a?noop=true")
                .filter(header(Exchange.FILE_NAME).startsWith(type))
                .to("file:C:/Users/amanp/OneDrive/Desktop/b");

    }


    public void moveSpecificFileWithBody(String content) {
        from("file:source?noop=true")
                .filter(body().startsWith(content))
                .to("file:destination");

    }


    public void fileProcess() {
        from("file:source?noop=true").process(p -> {
                    String body = p.getIn().getBody(String.class);
                    StringBuilder sb = new StringBuilder();

                    Arrays.stream(body.split(" ")).forEach(s -> {
                        sb.append(s + ",");
                    });

                    p.getIn().setBody(sb);
                })
                .to("file:destination?fileName=records.csv");

    }


    public void multiFileProcessor() {
        from("file:source?noop=true")
                .unmarshal().csv()
                .split(body().tokenize(","))
                .choice()
                .when(body().contains("Closed"))
                .to("file:destination?fileName=Closed.csv")
                .when(body().contains("Pending"))
                .to("file:destination?fileName=Pending.csv")
                .when(body().contains("Interest"))
                .to("file:destination?fileName=Interest.csv")
                .end();
    }

}
