package com.maxa.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "Assemble_Computer")
public class AssembleComputer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "computer_id")
    private Computer computer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "computer_parts_id")
    private ComputerParts computerParts;

    public AssembleComputer(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public ComputerParts getComputerParts() {
        return computerParts;
    }

    public void setComputerParts(ComputerParts computerParts) {
        this.computerParts = computerParts;
    }

}
