package org.lessons.scelac.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scelac
 */
@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/hello-admin")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<String> getAdminGreeting(){
        return ResponseEntity.ok("Hello Mr. Admin!");
    }

    @GetMapping("/hello-manager")
    @PreAuthorize("hasAnyAuthority('ADMIN','PRODUCT_MANAGER')")
    public ResponseEntity<String> getManagerGreeting(){
        return ResponseEntity.ok("Hello Mr. Manager!");
    }

    @GetMapping("/hello-tester")
    @PreAuthorize("hasAnyAuthority('ADMIN','TESTER')")
    public ResponseEntity<String> getUserGreeting(){
        return ResponseEntity.ok("Hello Mr. Tester!");
    }

    @GetMapping("/hello-guest")
    @PreAuthorize("hasAnyAuthority('ADMIN','GUEST')")
    public ResponseEntity<String> getGuestGreeting(){
        return ResponseEntity.ok("Hello Mr. Guest!");
    }
    @GetMapping("/hello-developer")
    @PreAuthorize("hasAnyAuthority('ADMIN','DEVELOPER')")
    public ResponseEntity<String> getDeveloperGreeting(){
        return ResponseEntity.ok("Hello Mr. DEVELOPER!");
    }
}
