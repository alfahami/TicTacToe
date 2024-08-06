package com.ltp.globalsuperstore.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;
import com.ltp.globalsuperstore.service.ServiceStore;
import com.ltp.globalsuperstore.service.ServiceStoreImpl;

@Controller
public class StoreController {

    StoreRepository storeRepository = new StoreRepository();
    ServiceStore serviceStore = new ServiceStoreImpl();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item", serviceStore.getItemById(id));
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if (item.getPrice() != null &&  item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Price cannot be less than discount");
            return "form";
        }
        if (result.hasErrors()) return "form";
        String status = serviceStore.SetStatus(item);
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", serviceStore.getItems());
        return "inventory";
    }

}
