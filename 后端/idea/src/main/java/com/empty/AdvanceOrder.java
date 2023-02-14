package com.empty;

import lombok.Data;

import java.sql.Time;

@Data
public class AdvanceOrder {
    private Integer id;
    private String user;
    private Integer table_id;
    private Time start_time;
    private Time end_time;
    private double money;
    private String state;


}
