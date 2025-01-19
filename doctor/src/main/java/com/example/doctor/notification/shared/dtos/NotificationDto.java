package com.example.doctor.notification.shared.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class NotificationDto implements Serializable {
   protected String message;
    protected String to ;
}
