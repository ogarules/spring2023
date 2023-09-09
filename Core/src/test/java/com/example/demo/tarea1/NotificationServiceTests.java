package com.example.demo.tarea1;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.tarea1.message.EmailMessageServiceImpl;
import com.example.demo.tarea1.message.FacebookMessageServiceImpl;
import com.example.demo.tarea1.message.TwitterMessageServiceImpl;
import com.example.demo.tarea1.notification.INotificationService;
import com.example.demo.tarea1.notification.NotificationType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationServiceTests {
    private static ApplicationContext context;

    @BeforeClass
    public static void beforeClass(){
        context = new ClassPathXmlApplicationContext("spring/tarea1/beans.xml");
    }

    @Test
    public void notificationServiceTest(){
        log.info("Testing notification service...");

        INotificationService notificationService = (INotificationService)context.getBean("notificationServiceBean");

        notificationService.notifyTo("ogaemail", "hola mundo", NotificationType.EMAIL);
        notificationService.notifyTo("ogafacebook", "hola mundo", NotificationType.FACEBOOK);
        notificationService.notifyTo("ogaetwitter", "hola mundo", NotificationType.TWITTER);

        assertEquals(FacebookMessageServiceImpl.class, notificationService.getFacebookMessageService().getClass());
        assertEquals(TwitterMessageServiceImpl.class, notificationService.getTwitterMessageService().getClass());
        assertEquals(EmailMessageServiceImpl.class, notificationService.getEmailMessageService().getClass());
    }
}
