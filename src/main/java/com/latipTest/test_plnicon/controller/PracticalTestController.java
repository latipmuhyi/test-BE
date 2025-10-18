package com.latipTest.test_plnicon.controller;

import com.google.gson.Gson;
import com.latipTest.test_plnicon.library.LoggerMapping;
import com.latipTest.test_plnicon.library.Response;
import com.latipTest.test_plnicon.service.PracticalTestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/practical")
@RequiredArgsConstructor
public class PracticalTestController {
    final PracticalTestService practicalTestService;
    Logger logger = LoggerFactory.getLogger(PracticalTestController.class);
    LoggerMapping loggerMapping = new LoggerMapping();
    Gson gson = new Gson();
    @GetMapping("/dashboard")
    public ResponseEntity<Response<?>> dashboard(HttpServletRequest request) {
        Response<?> response = practicalTestService.dashboard();
        loggerMapping.setData(response, request);
        logger.info(gson.toJson(loggerMapping));
        return ResponseEntity.ok(response);
    }
}
