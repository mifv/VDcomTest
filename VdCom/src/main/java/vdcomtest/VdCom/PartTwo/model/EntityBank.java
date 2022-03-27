package vdcomtest.VdCom.PartTwo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;


@Table(name= "BANK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityBank {

    @Column(name="BANK_ID")
    private int bankid;


    @Column(name="BANK_NAME")
    private String name;


    }

