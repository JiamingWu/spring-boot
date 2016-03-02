package hello.web.controller.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hello.model.UserData;
import hello.service.SampleService;

@RestController
@RequestMapping("/sample/")
public class SampleIndexController {

    @Autowired
    private SampleService sampleService;
    
    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/about");
    }
    
    @RequestMapping("user")
    public UserData queryFirstUserName() {
        List<UserData> data = sampleService.queryUsers();
        if (data.size() > 0) {
            return data.get(0);
        } else {
            return null;
        }
    }

    @RequestMapping("test")
    public String test() {
        return "test";
    }
}
