package org.osama.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.LinkedHashMap;


@Entity
@Table(name = "salary_table")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SALARY")
  private   Integer id ;

    @Column(name = "CODE_TRANSFER")
    private   Integer codeTransfer;

    @Column(name = "SEQUENCE")
   private String sequence;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "FULL_NAME")
    @Size(max = 20, min = 3, message = "{salary.fullName.invalid}")
    private String fullName;

    @Column(name = "SWIFT_CODE")
   private String bankSwiftCode;

    @Column(name = "BANK_NUMBER")
   private String bankNumber;

    @Column(name = "IC_NUMBER")
    @Pattern(regexp = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?", message = "Invalid Number")
  private   String icNumber;

    private LinkedHashMap<String,String> linkedHashMapBankName;
    public Salary() {
        linkedHashMapBankName =new LinkedHashMap<>();
        linkedHashMapBankName.put("AMISLAMIC BANK BERHAD","AMISLAMIC BANK BERHAD");
        linkedHashMapBankName.put("ASIAN FINANCE BANK BERHAD","ASIAN FINANCE BANK BERHAD");
        linkedHashMapBankName.put("BANGKOK BANK BERHAD","BANGKOK BANK BERHAD");
        linkedHashMapBankName.put("BANK ISLAM MALAYSIA BERHAD","BANK ISLAM MALAYSIA BERHAD");
        linkedHashMapBankName.put("BANK KERJASAMA RAKYAT MALAYSIA BERHAD (BANK RAKYAT)","BANK KERJASAMA RAKYAT MALAYSIA BERHAD (BANK RAKYAT)");
        linkedHashMapBankName.put("BANK MUAMALAT MALAYSIA BERHAD (6175-W)","BANK MUAMALAT MALAYSIA BERHAD (6175-W)");
        linkedHashMapBankName.put("BANK OF CHINA (MALAYSIA) BERHAD","BANK OF CHINA (MALAYSIA) BERHAD");
        linkedHashMapBankName.put("BANK PERTANIAN MALAYSIA BERHAD-AGROBANK","BANK PERTANIAN MALAYSIA BERHAD-AGROBANK");
        linkedHashMapBankName.put("BNP PARIBAS MALAYSIA BERHAD","BNP PARIBAS MALAYSIA BERHAD");
        linkedHashMapBankName.put("CHINA CONSTRUCTION BANK (MALAYSIA) BERHAD","CHINA CONSTRUCTION BANK (MALAYSIA) BERHAD");
        linkedHashMapBankName.put("CIMB BANK BERHAD","CIMB BANK BERHAD");
        linkedHashMapBankName.put("CIMB INVESTMENT BANK BERHAD","CIMB INVESTMENT BANK BERHAD");
        linkedHashMapBankName.put("CIMB ISLAMIC BANK BERHAD","CIMB ISLAMIC BANK BERHAD");
        linkedHashMapBankName.put("CIMB-PRINCIPAL ASSET MANAGEMENT BERHAD","CIMB-PRINCIPAL ASSET MANAGEMENT BERHAD");
        linkedHashMapBankName.put("CITIBANK BERHAD","CITIBANK BERHAD");
    }

    public LinkedHashMap<String, String> getLinkedHashMapBankName() {
        return linkedHashMapBankName;
    }

    public void setLinkedHashMapBankName(LinkedHashMap<String, String> linkedHashMapBankName) {
        this.linkedHashMapBankName = linkedHashMapBankName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }



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

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
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

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }
}
