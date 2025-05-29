package com.java.team.shippingservice.config;

import com.java.team.shippingservice.entity.enums.LanguageCodes;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class UserSession {
    public static CustomUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails details = (Objects.isNull(authentication) || isAnonymous(authentication)) ? null : (CustomUserDetails) authentication.getPrincipal();
        if (details == null)
            throw new RuntimeException("User not found");
        return details;
    }

    private static boolean isAnonymous(Authentication authentication) {
        return authentication.getPrincipal().equals("anonymousUser");
    }

    public static LanguageCodes getLanguage() {
        return LanguageCodes.valueOf(LocaleContextHolder.getLocale().getLanguage().toUpperCase());
    }

    public static boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (!Objects.isNull(authentication) && !isAnonymous(authentication));
    }
}
