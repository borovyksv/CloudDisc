package sources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {

    @Autowired
    private DataService dataService;

    @RequestMapping("/")
    public String index(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("login", user.getUsername());
        model.addAttribute("roles", user.getAuthorities());

        return "index";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }



    @RequestMapping(value = "/common", method = RequestMethod.POST)
    public String onAddFiles(@RequestParam("file") MultipartFile[] files, Model model) {
        for (MultipartFile f : files) {
            if (!f.isEmpty()) {
                dataService.addContact(f);
            }
        }
            return "result";

    }





    @RequestMapping("/unauthorized")
    public String unauthorized(Model model){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }
}
