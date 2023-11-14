package com.ParkingLot.SpringProject.Model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class User extends BaseModel {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
}
