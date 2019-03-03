package com.maxa.web.dto;

public class AssembleComputerDTO {

    private String computerName;

    private Double computerPrice;

    private String partType;

    private Double partPrice;

    private String partProducer;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Double getComputerPrice() {
        return computerPrice;
    }

    public void setComputerPrice(Double computerPrice) {
        this.computerPrice = computerPrice;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public Double getPartPrice() {
        return partPrice;
    }

    public void setPartPrice(Double partPrice) {
        this.partPrice = partPrice;
    }

    public String getPartProducer() {
        return partProducer;
    }

    public void setPartProducer(String partProducer) {
        this.partProducer = partProducer;
    }
}
