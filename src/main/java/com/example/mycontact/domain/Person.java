package com.example.mycontact.domain;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.dto.Birthday;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data // Getter Setter ToString RequiredArgsConstructor EqualsAndHashCode integrated 5
@Where(clause = "deleted = false")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    private String hobby;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    private String phoneNumber;

    @ColumnDefault("0")
    private boolean deleted;

    public void set(PersonDto personDto){

        if(!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }

        if(!StringUtils.isEmpty(personDto.getAddress())){
            this.setAddress(personDto.getAddress());
        }

        if(!StringUtils.isEmpty(personDto.getJob())){
            this.setJob(personDto.getJob());
        }

        if(!StringUtils.isEmpty(personDto.getPhoneNumber())){
            this.setPhoneNumber(personDto.getPhoneNumber());
        }

        if(personDto.getBirthday() != null) {
            this.setBirthday(Birthday.of(personDto.getBirthday()));
        }
    }

    public boolean isBirthdayToday(){
        return LocalDate.now().equals(LocalDate.of(this.birthday.getYearOfBirthday(), this.birthday.getMonthOfBirthday(), this.birthday.getDayOfBirthday()));
    }
    public Integer getAge(){
        if(this.birthday != null){
            return LocalDate.now().getYear() - this.birthday.getYearOfBirthday() + 1;
        } else {
            return null;
        }
    }
}
