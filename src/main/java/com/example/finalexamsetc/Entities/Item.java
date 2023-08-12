package com.example.finalexamsetc.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Item {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String catcode;

    private String icode;

    private String idesc;


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private  double price;


}

