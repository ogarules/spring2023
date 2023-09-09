package com.example.demo.tarea1.notification;

import com.example.demo.tarea1.message.IMessageService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Data
@Slf4j
public class NotificationServiceImpl implements INotificationService{
    IMessageService facebookMessageService;
    IMessageService emailMessageService;
    IMessageService twitterMessageService;

    @Override
    public void notifyTo(String user, String message, NotificationType notificationType){
        log.info("Sending message...");

        switch(notificationType){
            case FACEBOOK:
                facebookMessageService.sendMessage(user, message);
                break;
            case TWITTER:
                twitterMessageService.sendMessage(user, message);
                break;
            case EMAIL:
                emailMessageService.sendMessage(user, message);
                break;
        }
    }
}
