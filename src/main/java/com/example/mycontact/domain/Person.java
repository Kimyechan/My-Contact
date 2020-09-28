package com.example.mycontact.domain;

import com.example.mycontact.controller.dto.PersonDto;
import com.example.mycontact.domain.dto.Birthday;
import com.sun.istack.NotNull;
import lombok.*;
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
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Block block;

    public void set(PersonDto personDto){
        if(personDto.getAge() != 0){
            this.setAge(personDto.getAge());
        }

        if(!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }

        if(!StringUtils.isEmpty(personDto.getBloodType())){
            this.setBloodType(personDto.getBloodType());
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
    }
}
