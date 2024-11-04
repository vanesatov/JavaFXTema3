package org.example.javafxtema3.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private String correo;
    private String plataforma;
    private Boolean admin;
    private Integer version;
    private LocalDateTime horaFecha;
}
