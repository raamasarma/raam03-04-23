package com.raithanna.dairy.RaithannaDairy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class dailySales {
    @Id
    @GeneratedValue
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime date;

    @UpdateTimestamp
    @Column(insertable = false)
    private Date recDate;

    private Integer orderNo;


    private String prodCode;
    private String custCode;
    private Integer disc;

    private Double netAmount;

    private Double amount;

    private Integer quantity;

    private Double unitRate;

    private Integer totDisc;

    private Double totNetAmount;

    private Double totAmount;

}
