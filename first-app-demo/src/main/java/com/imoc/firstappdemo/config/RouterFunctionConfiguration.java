package com.imoc.firstappdemo.config;

import com.imoc.firstappdemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author jianghua
 * @date 2020/11/15
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * servlet
     * 请求接口：ServletRequest 或者 HttpServletResquest
     * 返回接口：ServletResponse 或者 HttpServletResponse
     *
     * Spring 5.0重新定义了服务请求和响应接口
     * 请求接口：ServerRequest
     * 返回接口：ServerResponse
     * 既可支持servlet规范，也可支持自定义，比如Netty(Web Server)
     *
     * 例如：
     * 定义Get请求，并且返回所有的用户对象，URI：/person/find/all
     */
    @Bean
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        return null;

    }
}
