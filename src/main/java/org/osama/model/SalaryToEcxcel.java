package org.osama.model;

public class SalaryToEcxcel {
        private Integer id ;
        private Integer codeTransfer;
        private Integer sequence;
        private String fullName;
        private String bankSwiftCode;
        private String bankNumber;
        private Integer icNumber;
        private String amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodeTransfer() {
        return codeTransfer;
    }

    public void setCodeTransfer(Integer codeTransfer) {
        this.codeTransfer = codeTransfer;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBankSwiftCode() {
        return bankSwiftCode;
    }

    public void setBankSwiftCode(String bankSwiftCode) {
        this.bankSwiftCode = bankSwiftCode;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public Integer getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(Integer icNumber) {
        this.icNumber = icNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
