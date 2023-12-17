package com.solix.jdp.MULTIPLE_DATABASES_CONNECTIVITY.secondaryDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class seconduser {
    @Id
    private int id;
    private String name;
    private String email;
}
