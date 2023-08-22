package com.batch.spring_batch_test.job.db_job.db_step;

import com.batch.spring_batch_test.job.db_job.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Slf4j
@Component
public class DbStepTaskLet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("--------task start-------");
        String path = new ClassPathResource("test.txt").getPath();
        log.info(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\work\\project\\spring_batch_test\\src\\main\\resources\\test.txt")));
        String line = null;
        String result = "";
        int i = 0;
        while ((line = br.readLine()) != null){
            result += line;
        }
        String[] split = result.split(" ");
        Item item = new Item(Long.parseLong(split[0]), split[1], Integer.parseInt(split[2]));
       log.info(item.toString());
        return RepeatStatus.CONTINUABLE;
    }
}
