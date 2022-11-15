package com.example.springsecurity.security;


import com.example.springsecurity.Entity.Etudiant;
import com.example.springsecurity.Entity.Rolee;
import com.example.springsecurity.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal implements UserDetails {

    private Long id;
    private String email;

    transient private String password;
    transient private Etudiant user;
    private Set<GrantedAuthority> authoroties;

    public static UserPrincipal createSuperUser(){
        Set<GrantedAuthority> authorities =
        new HashSet<>(Arrays.asList(SecurityUtils.convertToAuthority(Rolee.MANAGER.name())));

        return UserPrincipal.builder().id(-1L).email("system-administrator").authoroties(authorities).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoroties;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
