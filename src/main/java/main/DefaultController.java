package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by User on 25 Дек., 2019
 */
@RestController
public class DefaultController {
    @RequestMapping("/")
    public String index(){
        return (String.valueOf(new Random().nextInt()));
    }
}
