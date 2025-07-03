package com.example.demo.controller;

import com.example.demo.model.Parent;
import com.example.demo.model.Student;
import com.example.demo.repository.ParentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class AdminController {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentService studentService;

    // Form tạo parent
    @GetMapping("/admin/create-parent")
    public String createParentForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "admin-create-parent";
    }

    @PostMapping("/admin/create-parent")
    public String createParent(@ModelAttribute Parent parent, RedirectAttributes redirectAttributes) {
        if (parentRepository.findByUsername(parent.getUsername()) != null) {
            redirectAttributes.addFlashAttribute("message", "Username đã tồn tại!");
            return "redirect:/admin/create-parent";
        }
        parent.setPassword(passwordEncoder.encode(parent.getPassword()));
        parentRepository.save(parent);
        redirectAttributes.addFlashAttribute("message", "Tạo tài khoản phụ huynh thành công!");
        return "redirect:/admin/create-parent";
    }

    // Form tạo student
    @GetMapping("/admin/create-student")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "admin-create-student";
    }

    @PostMapping("/admin/create-student")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes, Model model) {
        if (studentRepository.findAll().stream().anyMatch(s -> s.getUsername().equals(student.getUsername()))) {
            redirectAttributes.addFlashAttribute("message", "Username đã tồn tại!");
            return "redirect:/admin/create-student";
        }
        // Lấy parent theo username nhập vào
        String parentUsername = model.asMap().getOrDefault("parentUsername", "").toString();
        Parent parent = parentRepository.findByUsername(parentUsername);
        if (parent == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy phụ huynh với username đã nhập!");
            return "redirect:/admin/create-student";
        }
        student.setParent(parent);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.save(student);
        redirectAttributes.addFlashAttribute("message", "Tạo tài khoản học sinh thành công!");
        return "redirect:/admin/create-student";
    }
} 