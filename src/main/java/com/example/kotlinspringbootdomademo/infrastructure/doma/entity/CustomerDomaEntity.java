package com.example.kotlinspringbootdomademo.infrastructure.doma.entity;

import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "customer")
public class CustomerDomaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String email;

    public String phone_number;

    public String github_name;

    public String twitter_name;

    public String main_org;

    public String sub_org;
}
