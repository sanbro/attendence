package com.sanbro.attendence.convertors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomAuthoritiesConvertor implements Converter<Jwt, Collection<GrantedAuthority>> {
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        return jwt.getClaimAsStringList("roles").stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
