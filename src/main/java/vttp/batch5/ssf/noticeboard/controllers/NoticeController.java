package vttp.batch5.ssf.noticeboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import vttp.batch5.ssf.noticeboard.models.NoticeModel;
import vttp.batch5.ssf.noticeboard.services.NoticeService;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String showNoticeForm(Model model) {
        model.addAttribute("notice", new NoticeModel());
        return "notice";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "redirect:/notice"; // Redirects to the notice form
    }

    @PostMapping("/notice")
    public String handleNoticeSubmission(@Valid @ModelAttribute("notice") NoticeModel notice, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "notice-form"; // Show the form again if there are errors
        }

        model.addAttribute("notice", notice);
        return "notice-success"; // Ensure a "notice-success.html" template exists for the success page
    }
}

