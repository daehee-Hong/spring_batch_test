package com.batch.spring_batch_test.job.db_job.db_service;

import com.batch.spring_batch_test.job.db_job.dto.Item;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
@Component
public class Job1ItemReader implements ItemReader<String> {
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String path = new ClassPathResource("test.txt").getPath();
        System.out.println(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\work\\project\\spring_batch_test\\src\\main\\resources\\test.txt")));
        String line = null;
        String result = "";
        int i = 0;
        while ((line = br.readLine()) != null){
            result += line;
        }
        return result.replace(" ", ",");

    }
}
