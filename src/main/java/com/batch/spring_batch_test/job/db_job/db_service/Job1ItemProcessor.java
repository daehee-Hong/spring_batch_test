package com.batch.spring_batch_test.job.db_job.db_service;

import com.batch.spring_batch_test.job.db_job.dto.Item;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Job1ItemProcessor implements ItemProcessor<String, Item> {
    @Override
    public Item process(String item) throws Exception {
        System.out.println("process : " + item);

        String[] split = item.split(",");

        return new Item(Long.parseLong(split[0]), split[1], Integer.parseInt(split[2]));
    }
}
