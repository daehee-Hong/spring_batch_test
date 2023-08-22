package com.batch.spring_batch_test.job.db_job.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Item {
    private Long serverIdx;
    private String ipAddr;
    private Integer collectGubun;
}
