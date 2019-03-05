package com.maxa.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Computer_Parts")
@Data
public class ComputerParts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "part_type")
    private String partType;

    @Column(name = "price")
    private Double price;

    @Column(name = "producer")
    private String producer;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "computerParts",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<AssembleComputer> assembleComputer=new ArrayList<>();
}
