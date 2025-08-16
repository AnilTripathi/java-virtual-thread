package com.virtual.thread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtual.thread.service.PlatformThreadService;
import com.virtual.thread.service.SimpleService;
import com.virtual.thread.service.VirtualThreadService;

@RestController
@RequestMapping("/thread")
public class VirtualThreadController {

    @Autowired
    private SimpleService reportService;

    @Autowired
    private PlatformThreadService platformReportService;

    @Autowired
    private VirtualThreadService virtualReportService;

    @PostMapping("/{region}")
    public ResponseEntity<String> generateReport(@PathVariable String region) {
        reportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ report started for region: " + region);
    }

    @PostMapping("/platform/{region}")
    public ResponseEntity<String> generateReportPlatform(@PathVariable String region) {
        platformReportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ Platform report started for region: " + region);
    }

    @PostMapping("/virtual/{region}")
    public ResponseEntity<String> generateReportVirtual(@PathVariable String region) {
        virtualReportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ Virtual report started for region: " + region);
    }

}