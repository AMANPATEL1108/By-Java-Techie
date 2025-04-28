package com.example.batch.api.config;

import com.example.batch.api.data.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.MongoPagingItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfig {

    @Autowired
    private JobBuilder jobBuilder;

    @Autowired
    private StepBuilder stepBuilder;

    @Autowired
    private MongoTemplate template;


    @Bean
    public MongoPagingItemReader<Person> reader() {

        MongoPagingItemReader<Person> reader = new MongoPagingItemReader<>();
        reader.setTemplate(template);
        reader.setQuery("{}");
        reader.setTargetType(Person.class);
        reader.setSort(new HashMap<String, Sort.Direction>() {
            {
                put("_custId", Sort.Direction.DESC);
            }
        });
        return reader;
    }

    @Bean
    public StaxEventItemWriter<Person> writer() {
        StaxEventItemWriter<Person> writter = new StaxEventItemWriter<Person>();
        writter.setRootTagName("Persons");
        writter.setResource(new FileSystemResource("xml/bank.xml"));
        writter.setMarshaller(marshaller());
        return writter;
    }

    private XStreamMarshaller marshaller() {

        XStreamMarshaller marshaller = new XStreamMarshaller();
        Map<String, Class> map = new HashMap<>();
        map.put("Person", Person.class);
        marshaller.setAliases(map);
        return marshaller;
    }


}
