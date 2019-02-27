package com.maxa.web.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Computer_Parts")
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

    @OneToMany(mappedBy = "computerParts",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssembleComputer> assembleComputer=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public List<AssembleComputer> getAssembleComputer() {
        return assembleComputer;
    }

    public void setAssembleComputer(List<AssembleComputer> assembleComputer) {
        this.assembleComputer = assembleComputer;
    }
}
