package com.maxa.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Computer")
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "computer_name")
    private String computerName;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy = "computer",cascade = CascadeType.ALL, orphanRemoval = true)
    //@JoinColumn(name = "computer_id")
    private List<AssembleComputer> assembleComputer=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<AssembleComputer> getAssembleComputer() {
        return assembleComputer;
    }

    public void setAssembleComputer(List<AssembleComputer> assembleComputer) {
        this.assembleComputer = assembleComputer;
    }
}
