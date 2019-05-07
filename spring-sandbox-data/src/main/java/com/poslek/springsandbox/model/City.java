package com.poslek.springsandbox.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.poslek.springsandbox.serialiazers.CustomSuperHeroSerializer;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Builder
    public City(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    @JsonSerialize(using = CustomSuperHeroSerializer.class)
    private Set<SuperHero> superHeroes = new HashSet<>();

}
