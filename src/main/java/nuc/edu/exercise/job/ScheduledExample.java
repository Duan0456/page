package nuc.edu.exercise.job;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import nuc.edu.exercise.base.BaseResponse;
import nuc.edu.exercise.service.impl.ScheduledImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledExample {

    @Autowired
    ScheduledImpl scheduled;

    @Scheduled(cron = "0/2 * * * * ?")
    public void job(){
        try {
            scheduled.check(0);
        } catch (Exception ex){
            log.error("定时任务错误");
        }
    }
}
