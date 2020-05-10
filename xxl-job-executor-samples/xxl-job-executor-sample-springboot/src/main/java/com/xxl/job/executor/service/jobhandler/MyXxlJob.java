package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义任务处理逻辑类
 *
 * @author zhangjuwa
 * @apiNote
 * @date 2020-05-10 21:59
 * @since jdk1.8
 */
@Component
@Slf4j
public class MyXxlJob {

    /**
     * @param param 打印当前时间
     * @return
     */
    @XxlJob(value = "firstXxl-job", destroy = "destroy")
    public ReturnT<String> printCurrentTime(String param) {
        log.info("传入参数={}，currentThread={}", param,Thread.currentThread().getName());
        XxlJobLogger.log("currentTime=" + LocalDateTime.now());
        return ReturnT.SUCCESS;
    }

    public void destroy() {
        log.info("destory");
    }


}
