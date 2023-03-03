package com.example.ss8_baitap.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Không được bỏ trống  ")
    @Size(min = 5, max = 45,message = "Độ dài phải tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String fistName;

    @NotEmpty(message = "Không được bỏ trống  ")
    @Size(min = 5, max = 45,message = "Độ dài phải tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String lastName;

    @Pattern(regexp = "(\\+84|0)[0-9]{9}",message = "đầu số +84 hoặc 0 và 10 số ")
    private String phoneNumber;

    @Min(value = 18,message = "Phải lớn hơn hoặc bằng 18 tuổi")
    private Integer age;

    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@gmail.com$",message = "Chưa đúng định dạng mail")
    private String email;




}
