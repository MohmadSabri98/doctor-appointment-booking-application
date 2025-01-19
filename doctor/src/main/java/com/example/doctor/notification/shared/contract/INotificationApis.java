package com.example.doctor.notification.shared.contract;

import com.example.doctor.notification.shared.dtos.NotificationDto;

public interface INotificationApis {
    <T extends NotificationDto> void notify(T eventNotificationDto);

}
