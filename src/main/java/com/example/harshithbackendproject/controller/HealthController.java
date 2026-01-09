package com.example.harshithbackendproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<HealthResponse> health() {

        boolean systemHealthy = checkSystemHealth();

        if (systemHealthy) {
            return ResponseEntity.ok(
                    new HealthResponse("UP", "Application is running normally")
            );
        }

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new HealthResponse("DOWN", "Critical system dependency failed"));
    }

    private boolean checkSystemHealth() {
        // TODO: Replace with real checks
        // Example:
        // - Database connectivity
        // - External API reachability
        // - Disk space
        return true; // simulate healthy system
    }
}
