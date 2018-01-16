package com.devopsbuddy.devopsbuddy.web.controller;

import com.devopsbuddy.devopsbuddy.service.email.SmtpEmailService;
import com.devopsbuddy.devopsbuddy.service.movies.MoviesService;
import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.FeedBackPojo;
import com.devopsbuddy.devopsbuddy.web.controller.domain.frontend.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
public class PageController {



    private static final Logger LOG = LoggerFactory.getLogger(PageController.class);

    public static final String FEEDBACK_MODEL_KEY="feedback";

    private static final String CONTACT_US_VIEW_NAME="contact";

    private static final String LIST_ALL_MOVIES_VIEW="listall";

    @Autowired
    private SmtpEmailService emailService;

    @Autowired
    private MoviesService moviesService;

    @RequestMapping("/locale")
    public String home(Locale locale)
    {
        return locale.toString();
    }

    @RequestMapping("/")
    String mainPage()
    {
        LOG.info("main method entered..");
        return "index";
    }

    @RequestMapping(value="/listall")
    public ModelAndView listAllMovies(Model modelAttribute)

    {
        List<Movie> moviesList = (List<Movie>) moviesService.findAll();
        moviesService.findAll().forEach(movie -> System.out.println(movie));
        ModelAndView modelAndView = new ModelAndView(LIST_ALL_MOVIES_VIEW);
        modelAndView.addObject("movies",moviesList);
        return modelAndView;
    }

    @RequestMapping("/about")
    String aboutPage()
    {
        return "about";
    }

    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contantGet(ModelMap modelMap)
    {
        FeedBackPojo feedbackModel = new FeedBackPojo();
        modelMap.addAttribute(PageController.FEEDBACK_MODEL_KEY,feedbackModel);
        return PageController.CONTACT_US_VIEW_NAME;
    }

    @RequestMapping(value = "/contact",method = RequestMethod.POST)
    public String contantPOST(@ModelAttribute("feedback") FeedBackPojo feedBackPojo)
    {
        LOG.debug("Feedback pojo content: {}",feedBackPojo);
        emailService.sendFeedBackEmail(feedBackPojo);
        return PageController.CONTACT_US_VIEW_NAME;
    }

}
