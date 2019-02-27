package com.maxa.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assemble_Computer")
public class AssembleComputer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "computer_id", insertable = false, updatable = false)
    private Computer computer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "computer_parts_id", insertable = false, updatable = false)
    private ComputerParts computerParts;

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
