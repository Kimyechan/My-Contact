package com.example.mycontact.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
public class Birthday {

    private Integer yearOfBirthday;

    @Min(1)
    @Max(12)
    private Integer monthOfBirthday;

    @Min(1)
    @Max(31)
    private Integer dayOfBirthday;

    public Birthday(LocalDate birthday){
        this.dayOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.yearOfBirthday = birthday.getYear();
    }
}
