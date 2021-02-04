package com.imoc.firstappdemo.controller;

import com.imoc.firstappdemo.demo.guava.caffeine.UserInfo;
import com.imoc.firstappdemo.demo.guava.caffeine.UserInfoService;
import com.imoc.firstappdemo.demo.semaphore.FrequencyController;
import com.imoc.firstappdemo.domain.User;
import com.imoc.firstappdemo.repository.UserRepository;
import com.imoc.firstappdemo.util.ThreadPools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author jianghua
 * @date 2020/11/15
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    private static FrequencyController controller;

    @Autowired
    private UserInfoService userInfoService;


    static {
        controller = new FrequencyController(2);
        ThreadPools.getInstance().submitsemaphoreTask(controller);
    }

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userRepository.save(user)) {
            System.out.printf("用户对象:%s保存成功\n", user);
        }
        return user;
    }


    @PostMapping("/kafka/semaphore")
    public String semaphore(@RequestParam String name) {
        try {
            long start = System.currentTimeMillis();
            controller.getSemaphore().acquireUninterruptibly(1);
            System.out.println("semaphore请求." + name+"; 间隔："+ (System.currentTimeMillis() - start));
            return "OK";
        } catch (Exception e) {
            System.out.printf("异常");
        }

        return "ERROR";
    }

    @PostMapping("/caffeine/query")
    public UserInfo caffeineCacheTest(@RequestParam String guid) {

        UserInfo userInfo = userInfoService.getByUserId(guid);
        return userInfo;
    }


}
