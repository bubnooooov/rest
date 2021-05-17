package com.bubnov.bootproject.exceptions;

import lombok.Data;

import java.util.Date;

@Data
public class IncorrectData {
    private String info;
    private Date date;

    public IncorrectData() {
        date = new Date();
    }
}
