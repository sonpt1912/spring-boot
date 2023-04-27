package com.example.event_async;

import org.springframework.context.ApplicationEvent;

/**
 * DoorBellEvent phải kế thừa lớp ApplicationEvent của
 * Spring
 * như vậy nó mới được coi là sự kiện hợp lệ
 */
public class DoorBellEvent extends ApplicationEvent {
    /**
     * mọi keess thừa applicationEvent sẽ
     * phải go constructor tới lop cha.
     */

    public DoorBellEvent(Object source, String guestName) {
        // object source là object tham chiếu tới nơi
        // phát hiện ra event này
        super(source);
    }
}
