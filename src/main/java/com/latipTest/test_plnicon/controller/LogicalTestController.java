package com.latipTest.test_plnicon.controller;

import com.google.gson.Gson;
import com.latipTest.test_plnicon.library.LoggerMapping;
import com.latipTest.test_plnicon.library.Response;
import com.latipTest.test_plnicon.service.LogicalTestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logical")
@RequiredArgsConstructor
public class LogicalTestController {
    final LogicalTestService logicalTestService;
    Logger logger = LoggerFactory.getLogger(LogicalTestController.class);
    LoggerMapping loggerMapping = new LoggerMapping();
    Gson gson = new Gson();

    @GetMapping("/test1")
    public ResponseEntity<Response<?>> balikKalimat(HttpServletRequest httpServletRequest){
        Response<?> response = logicalTestService.balikKalimat();
        loggerMapping.setData(response,httpServletRequest);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test2")
    public ResponseEntity<Response<?>> angka(HttpServletRequest httpServletRequest){
        Response<?> response = logicalTestService.angka();
        loggerMapping.setData(response,httpServletRequest);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test3")
    public ResponseEntity<Response<?>> jumlah(HttpServletRequest httpServletRequest){
        Response<?> response = logicalTestService.jumlah();
        loggerMapping.setData(response,httpServletRequest);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test4")
    public ResponseEntity<Response<?>> nilaiSaham(HttpServletRequest httpServletRequest){
        Response<?> response = logicalTestService.nilaiSaham();
        loggerMapping.setData(response,httpServletRequest);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/test5")
    public ResponseEntity<Response<?>> hitungAngka(HttpServletRequest httpServletRequest){
        Response<?> response = logicalTestService.hitungAngka();
        loggerMapping.setData(response,httpServletRequest);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
}
