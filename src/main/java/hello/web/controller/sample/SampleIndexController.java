package hello.web.controller.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample/")
public class SampleIndexController {

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/about");
    }

}
