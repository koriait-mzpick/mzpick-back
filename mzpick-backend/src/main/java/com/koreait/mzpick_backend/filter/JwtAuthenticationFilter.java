package com.koreait.mzpick_backend.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.koreait.mzpick_backend.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            // Request 객체에서 Bearer Token 추출
            String token = parseBearerToken(request);
            if(token == null){
                filterChain.doFilter(request, response);
                return;
            }
            // Token 검증
            String userId = jwtProvider.validate(token);
            if(userId == null) {
                filterChain.doFilter(request, response);
                return;
            }

            setContext(request, userId);
        } catch(Exception exception){
            exception.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }

    //request로 부터 토큰 추출
    private String parseBearerToken(HttpServletRequest request){

        //Request 객체의 Header에서 Authorization 필드 값을 가져옴
        String authorization = request.getHeader("Authorization");

        //추출한 Authorization값이 실제로 존재하는 문자열인지 확인
        boolean hasAuthorization = StringUtils.hasText(authorization);
        if(!hasAuthorization) return null;

        //Bearer 인증 방식인지 확인
        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        //Authorization 필드 갑에서 토큰 추출
        String token = authorization.substring(7);
        return token;
    }

    private void setContext(HttpServletRequest request, String userId){

        //접근 주체에 대한 인증 토큰 생성
        AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId, null ,AuthorityUtils.NO_AUTHORITIES);
        
        //생성한 인증 토큰이 어떤 요청에 대한 내용인지 상세 정보 추가
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //빈 security context 생성
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        
        //생성한 빈 security context에 authenticationToken 주입
        securityContext.setAuthentication(authenticationToken);

        //생성한 security context 등록
        SecurityContextHolder.setContext(securityContext);
    }

}