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
public class BankAccount extends BaseEntity<Long> {

    @Column(name = "card_number", nullable = false)
    private String cardNumber;


    @Column(name = "cvv2")
    private int cvv2;


    @Column(name = "exp_month")
    private int expMonth;

    @Column(name = "exp_year")
    private int expYear;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToMany(mappedBy = "loan",cascade = CascadeType.ALL)
    private List<Loan> loanList;


    @Override
    public String toString() {
        return "BankAccount{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cvv2=" + cvv2 +
                ", expMonth=" + expMonth +
                ", student=" + student +
                ", id=" + id +
                '}';
    }
}

