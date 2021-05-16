package br.com.course.ms.oauth.server.service;

import br.com.course.ms.oauth.server.client.UserFeignClient;
import br.com.course.ms.oauth.server.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = this.userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: "+ email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("Email found: "+ email);
        return user;
    }

}
