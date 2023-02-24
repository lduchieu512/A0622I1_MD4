package com.example.ss8_baitap.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @NotBlank
    @Size(min = 5, max = 45,message = "Không được bỏ trống hoặc đồ dài phải tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String fistName;

    @NotBlank
    @Size(min = 5, max = 45,message = "Không được bỏ trống hoặc đồ dài phải tối thiểu 5 kí tự và tối đa 45 kí tự")
    private String lastName;

//    @Pattern(regexp = "(\\+84|0)[0-9]{9}",message = "đầu số +84 hoặc 0 và 10 số ")
    private Integer phoneNumber;

    @Min(value = 18,message = "Phải lớn hơn hoặc bằng 18 tuổi")
    private Integer age;

    @Email(message = "Chưa đúng định dạng mail")
    private String email;



}
