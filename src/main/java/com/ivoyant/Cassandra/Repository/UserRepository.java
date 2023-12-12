package com.ivoyant.Cassandra.Repository;

import com.ivoyant.Cassandra.Model.UserData;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CassandraRepository<UserData,Integer> {

    @AllowFiltering
    List<UserData> findByAgeGreaterThan(int age);
}
