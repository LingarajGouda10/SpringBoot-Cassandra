package com.ivoyant.Cassandra.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Indexed
    private String city;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "user")
    private String landmark;
    @Indexed
    private String country;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "address")
    private int pinCode;

}
