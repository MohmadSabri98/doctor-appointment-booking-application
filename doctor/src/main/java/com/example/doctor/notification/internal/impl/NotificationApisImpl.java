package com.example.doctor.notification.internal.impl;

import com.example.doctor.notification.shared.contract.INotificationApis;
import com.example.doctor.notification.shared.dtos.NotificationDto;
import com.example.doctor.shared.domain.ILogger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationApisImpl implements INotificationApis {

    private final ILogger iLogger;

    @Override
    public <T extends NotificationDto> void notify(T eventNotificationDto) {
        iLogger.info(eventNotificationDto.getMessage()+"to"+eventNotificationDto.getTo());

    }
}
