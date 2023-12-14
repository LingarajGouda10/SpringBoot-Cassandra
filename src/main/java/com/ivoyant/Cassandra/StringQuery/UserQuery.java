package com.ivoyant.Cassandra.StringQuery;

public class UserQuery {
    public static final String SELECT_ADDRESS_QUERY = "Select addressCity,addressCountry,addressLandmark from userData"
            + " where age=";
    public static final String SELECT_ALL_USERS_QUERY = "select * from userData";

    public static final String SELECT_USER_BY_COUNTRY_QUERY = "Select * from userdata where addressCountry='";

    public static final String SELECT_USER_BY_CITY_QUERY = "Select * from userdata where addressCity='";

    public static final String SELECT_USER_BY_GENDER_QUERY = "Select * from userdata where gender='";

    public static final String SELECT_USER_BY_NAME_QUERY = "Select * from userData where name='";

    public static final String SELECT_USER_BY_CUSTOMISED_AGE_QUERY =
            "SELECT * from userData where age <= ";
    public static final String AGE_FILTER_CONDITION = " AND age >= ";
    public static final String ALLOW_FILTERING_SUFFIX = " ALLOW FILTERING";
}
