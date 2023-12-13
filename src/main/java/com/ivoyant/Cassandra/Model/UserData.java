package com.ivoyant.Cassandra.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    @PrimaryKey
    private int id;
    @Indexed
    private String name;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "user")
    @Indexed
    private String gender;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "user")
    @Indexed
    private int age;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL, prefix = "address")
    private Address address;


}
