package com.example.event_async;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyDog {

    /**
     * @EventListener sẽ lắng nghe mọi sự kiện xảy ra
     * nếu có một sự kiện DoorBellEvent được bắn ra, nó
     * sẽ đón lấy và đưa vào hàm để xử lý
     */

    @EventListener
    public void doorBellEventListener(DoorBellEvent doorBellEvent) throws InterruptedException {
        // giả sử con chó đang ng, 1 giây sau mới dậy
        Thread.sleep(1000);
        // sự kiện doorBellEvent được lawnsg nghe và xử lý tại đây
        System.out.println(Thread.currentThread().getName() + "chó ngủ dậy!!");

        System.out.println(String.format("%s: Go Go! có nguowif gõ cửa", Thread.currentThread().getName()));
    }

}
