package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
public class Loan extends BaseEntity<Long> {

    @Column(name = "loan_amount")
    private String loanAmount;

    @Column(name = "loan_date")
    private String loanDate;

    @Column(name = "semester")
    private String semester;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;

    @OneToMany(mappedBy = "installment", cascade = CascadeType.ALL)
    private List<Installment> installments;


    @Override
    public String toString() {
        return "Loan{" +
                "loanAmount='" + loanAmount + '\'' +
                ", loanDate='" + loanDate + '\'' +
                ", semester='" + semester + '\'' +
                ", student=" + student +
                ", bankAccount=" + bankAccount +
                ", installments=" + installments +
                ", id=" + id +
                '}';
    }
}
