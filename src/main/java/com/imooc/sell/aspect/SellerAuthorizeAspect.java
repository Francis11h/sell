//package com.imooc.sell.aspect;
//
//import com.imooc.sell.constant.CookieConstant;
//import com.imooc.sell.constant.RedisConstant;
//import com.imooc.sell.exception.SellException;
//import com.imooc.sell.exception.SellerAuthorizeException;
//import com.imooc.sell.utils.CookieUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.support.RequestContext;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 卖家授权切面
// *
// */
//
//
//@Aspect
//@Component
//@Slf4j
//public class SellerAuthorizeAspect {
//
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    //切入点
//    @Pointcut("execution(public * com.imooc.sell.controller.Seller*.*(..))" +
//    "&& !execution(public * com.imooc.sell.controller.SellerUserController.*(..))")
//
//    public void verify() {}
//
//    //在切入点之前做这个操作
//    @Before("verify()")
//    public void doVerify() {
//        /**获取需要的 http request*/
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        /**查询cookie  */
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登陆校验】Cookie中查不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        /**去 redis里查 */
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登陆校验】redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
