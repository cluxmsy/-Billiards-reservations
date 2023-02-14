package com.empty;

import lombok.Data;

import java.sql.Time;

@Data
public class Remark {
    private Integer id;
    private String comment;
    private String commented;
    private double point;
    private Time time;
    private boolean isDelet;
    private String content;


}
