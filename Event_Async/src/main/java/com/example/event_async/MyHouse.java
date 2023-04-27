package com.example.event_async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyHouse {
    /**
     * để bắn ra một sự kiện chúng ta sử dụng đối
     * tượng applicationEventPublisher. đây là một bean có
     * sẵn trong context do spring cung cấp, chỉ cần lôi ra để dùng
     */

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    /**
     * hành động bấm chuông cửa
     */

    public void rangDoorBellBy(String guestName) {
        // phát ra một sự kện DoorBellEvent
        // source (nguồn phát ra) chính là class này
        applicationEventPublisher.publishEvent(new DoorBellEvent(this, guestName));
    }

}
