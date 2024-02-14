package com.example.gamerboxd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Games")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String genero;
}
