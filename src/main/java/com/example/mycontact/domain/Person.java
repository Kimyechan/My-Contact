package com.example.mycontact.domain;

import com.example.mycontact.domain.dto.Birthday;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
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
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
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
}
