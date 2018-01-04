package io.khasang.hotel.dto;

import io.khasang.hotel.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ClientDTO {
    private long id;
    private String family;
    private String name;
    private String secondName;
    private Photo photoPassport;
    private Photo photoLogin;
    private LocalDate dateOfBirth;
    private LocalDate registered = LocalDate.now();
    private String coupon;
    private int level;
    private Contacts contact = new Contacts();
}
