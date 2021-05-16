package br.com.course.ms.oauth.server.controller;

import br.com.course.ms.oauth.server.domain.User;
import br.com.course.ms.oauth.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth/users")
@RequiredArgsConstructor
public class OAuthUserController {

    private final UserService userService;

    @GetMapping("search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        try{
            return ResponseEntity.ok(this.userService.findByEmail(email));
        } catch (IllegalArgumentException ex){
            return ResponseEntity.notFound().build();
        }
    }

}
