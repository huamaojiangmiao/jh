package com.imoc.firstappdemo.config;

import com.imoc.firstappdemo.domain.User;
import com.imoc.firstappdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

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
     * Flux 是0～N个对象集合
     * Mono 是0～1个对象集合
     * Reactive 中的 Flux 和 Mono 它是异步处理（非阻塞）
     * 集合对象基本是同步处理（阻塞）
     *
     * Flux 和 Mono 基本都是Publisher, 发布器
     *
     * // https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                });

    }
}
