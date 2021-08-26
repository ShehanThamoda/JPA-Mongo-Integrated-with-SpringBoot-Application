package lk.dialog.test.controller;

import io.swagger.annotations.ApiOperation;
import lk.dialog.test.request.AuthenticationRequest;
import lk.dialog.test.response.AuthenticationResponse;
import lk.dialog.test.service.UserDetailsService;
import lk.dialog.test.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shehan
 */
@RestController
public class AuthenticateController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * @des generate token using user credentials in here
     * @param authenticationRequest
     * @return ResponseEntity<AuthenticationResponse>
     * @throws Exception
     */
    @ApiOperation(value = "Authenticate", notes = "Authenticate the user")
    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(
            @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        long startTime = System.currentTimeMillis();
        logger.info("START | authentication - authenticationRequest: {}", authenticationRequest.toString());
       try{
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
           );
       }catch (BadCredentialsException ex){
           throw new Exception("Incorrect username or password!",ex);
       }
       final UserDetails userDetails=  userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
       final String jwt = jwtUtil.generateToken(userDetails);

        long endTime = System.currentTimeMillis();
        logger.info("END | authentication | TOTAL_RESPONSE_TIME_MILSEC - {}", (endTime - startTime));
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponse(jwt));
    }

}
