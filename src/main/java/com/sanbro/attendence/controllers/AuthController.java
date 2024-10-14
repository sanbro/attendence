package com.sanbro.attendence.controllers;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.sanbro.attendence.entities.User;
import com.sanbro.attendence.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2Token;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("authentication/v1")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final UserService userService;

//    @Autowired
//   private AbstractOAuth2TokenAuthenticationToken<OAuth2Token> authentication;


    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> publicEndpoint(@RequestParam(required = true) String userName, @RequestParam String password) {
        try{
//            HttpResponse<String> response = Unirest.post("https://dev-6ymsoam1qbexmmim.us.auth0.com/oauth/token")
//                    .header("content-type", "application/x-www-form-urlencoded")
//                    .body("grant_type=readuser&client_id=RIUOdiVEXYLz6S1CwZZbtc2xwfAY3Flv&client_secret=%7ByourClientSecret%7D&code=yourAuthorizationCode%7D&redirect_uri={https://localhost/authentication/v1/login}")
//                    .asString();
         // String token =  response.getBody();

         //  String token = authentication.getToken().getTokenValue();

            Map<String, Object> map = new  HashMap<>();
            map.put("token","empty");
            map.put("user", userService.getUserByName(userName));
            return ResponseEntity.ok().body(map);
        } catch (Exception e) {
           // throw new RuntimeException(e);
             ResponseEntity.internalServerError().build();
        }




         //token = new OAuth2AccessToken();
          //  return ResponseEntity.ok().body(userService.getUserByName(userName));
        return null;
    }

    private String generateJwtToken(Authentication authentication) {
        // Implement JWT generation logic
        return "generated_jwt_token"; // Replace with actual token generation
    }


    @GetMapping("/private")
    public String privateEndpoint() {
        return "This is a private endpoint";
    }
}