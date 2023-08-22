package com.batch.spring_batch_test.job.db_job.db_service;

import com.batch.spring_batch_test.job.db_job.dto.Item;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Job1ItemWriter implements ItemWriter<Item> {

    @Override
    public void write(List<? extends Item> list) throws Exception {
        System.out.println("write : " + list);

    }
}
