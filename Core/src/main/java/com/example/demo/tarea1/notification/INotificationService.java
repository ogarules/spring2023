package com.example.demo.tarea1.notification;

import com.example.demo.tarea1.message.IMessageService;

public interface INotificationService {
    
    IMessageService getFacebookMessageService();
    IMessageService getEmailMessageService();
    IMessageService getTwitterMessageService();

    void notifyTo(String user, String message, NotificationType notificationType);
}
