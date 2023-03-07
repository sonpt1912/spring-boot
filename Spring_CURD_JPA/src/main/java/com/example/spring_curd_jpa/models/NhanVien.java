package com.example.spring_curd_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Nhan_Vien")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "FULL_NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;
}
