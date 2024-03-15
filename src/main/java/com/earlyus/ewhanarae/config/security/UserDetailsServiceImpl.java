package com.earlyus.ewhanarae.config.security;

import com.earlyus.ewhanarae.domain.member.domain.Member;
import com.earlyus.ewhanarae.domain.member.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Entering in loadUserByUsername Method...");
        Member user = memberRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("authentication failed")
        );

        logger.info("User Authenticated Successfully..!!!");
        return new CustomUserDetails(user);
    }
}

