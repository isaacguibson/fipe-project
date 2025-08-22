package com.mbank.auth;

import io.quarkus.security.credential.PasswordCredential;
import io.quarkus.security.identity.AuthenticationRequestContext;
import io.quarkus.security.identity.request.UsernamePasswordAuthenticationRequest;
import io.quarkus.security.identity.IdentityProvider;
import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.runtime.QuarkusPrincipal;
import io.quarkus.security.runtime.QuarkusSecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class CustomIdentityProvider implements IdentityProvider<UsernamePasswordAuthenticationRequest> {

    @Override
    public Class<UsernamePasswordAuthenticationRequest> getRequestType() {
        return UsernamePasswordAuthenticationRequest.class;
    }

    @Override
    public Uni<SecurityIdentity> authenticate(UsernamePasswordAuthenticationRequest usernamePasswordAuthenticationRequest, AuthenticationRequestContext authenticationRequestContext) {
        String username = usernamePasswordAuthenticationRequest.getUsername();
        String password = new String(usernamePasswordAuthenticationRequest.getPassword().getPassword());

        // Fixed user logic
        if ("admin".equals(username) && "1234".equals(password)) {
            SecurityIdentity identity = QuarkusSecurityIdentity.builder()
                    .setPrincipal(new QuarkusPrincipal("admin"))
                    .addRole("user")
                    .addRole("admin")
                    .addCredential(new PasswordCredential("1234".toCharArray()))
                    .addAttribute("email", "user@example.com")
                    .build();
            return Uni.createFrom().item(identity);
        }

        return Uni.createFrom().failure(() -> new SecurityException("Invalid username or password"));
    }

    @Override
    public int priority() {
        return IdentityProvider.super.priority();
    }
}