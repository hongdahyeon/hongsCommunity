package hongs.community.hongsCommunity.global.hongs.dto;

import hongs.community.hongsCommunity.global.hongs.dto.request.CreateRequest;
import hongs.community.hongsCommunity.global.hongs.dto.request.UpdateRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Aspect
@Order(0)
@Component
public class HongsRequestAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    private void setCreatedBy(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (ObjectUtils.isEmpty(args) || args.length == 0) {
            return;
        }

        setUserUid(args);
    }

    private void setUserUid(Object[] args) {
        Long userUid = 1L;
            for (Object arg : args) {
                setCreated(userUid, arg);
                setUpdated(userUid, arg);
            }
    }

    /* TODO: get Security User
    private SecurityUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (SecurityHelper.isAnonymous(authentication)) {
            return null;
        }
        return SecurityHelper.getUser(authentication);
    }
    */

    private void setCreated(Long userUid, Object arg) {
        if (arg instanceof CreateRequest) {
            ((CreateRequest) arg).setRegId(userUid);
            ((CreateRequest) arg).setMdfrId(userUid);
        }
    }

    private void setUpdated(Long userUid, Object arg) {
        if (arg instanceof UpdateRequest) {
            ((UpdateRequest) arg).setMdfrId(userUid);
        }
    }
}
