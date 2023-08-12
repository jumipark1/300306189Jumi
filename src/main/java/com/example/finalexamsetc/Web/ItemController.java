package com.example.finalexamsetc.Web;

import com.example.finalexamsetc.Entities.Item;
import com.example.finalexamsetc.Repositories.ItemRepository;
import com.example.finalexamsetc.javat.Items;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.List;

@RequestMapping
@Controller
@AllArgsConstructor
@SessionAttributes({"id", "errorMessage"})

public class ItemController {

    @Autowired
    private ItemRepository itemRepository;



    @GetMapping(path = "/index")
    public String items(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword){


        List<Item> items;
        if (keyword.isEmpty()){
            items = itemRepository.findAll();
        }
        else {
            long key = Long.parseLong(keyword);
            items = itemRepository.findItemById(key);
        }

        model.addAttribute("listitems", items);

        return "items";
    }

    @GetMapping(path = "/delte")
    public String delete(Long id){
        itemRepository.deleteById(id);

        return "redirect:/index";
    }
    @GetMapping(path = "/update")
    public String update(ModelMap model, @RequestParam (defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        List<Item> items;
        if (id.isEmpty()){
            items = itemRepository.findAll();
        }
        else {
            long key = Long.parseLong(id);
            items = itemRepository.findItemById(key);
        }

        model.addAttribute("updateitems", items);

        return "items";

    }

}
