package q9029.app.spring.controller;

import java.security.Principal;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import q9029.app.spring.service.IUsersService;

@Controller
@RequestMapping(value = "/")
class IndexController {

    @Autowired
    private Properties applicationProperties;

    @Autowired
    IUsersService service;

    @RequestMapping(method = RequestMethod.GET)
    String doGet(HttpServletRequest request, HttpSession session, Principal principal) {
    	request.setAttribute("user", service.getUserInfo(principal.getName()));
        return applicationProperties.getProperty("view-index");
    }
}