package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.controllers;

import java.util.List;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.dto.SucursalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.services.SucursalService;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listSucursalDTO", sucursalService.findAll());
        return "index";
    }

    //create new
    @PostMapping("/add")
    public String create (@ModelAttribute SucursalDTO sucursalDTO){
        sucursalService.save(sucursalDTO);
        return "redirect:/sucursal/";
    }

    @GetMapping("/showNewSucursalForm")
    public String showNewSucursalForm(Model model) {
        // create model attribute to bind form data
        SucursalDTO dto = new SucursalDTO();
        model.addAttribute("sucursal", dto);
        return "add-sucursal";
    }


    //read by id
    @GetMapping("/getOne/{id}")
    public String read(@PathVariable(value = "id") int id, Model model) {
        SucursalDTO dto = sucursalService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("sucursal", dto);
        return "update-sucursal";
    }

    //read all
    @GetMapping("/getAll")
    public List<SucursalDTO> readAll() {
        return sucursalService.findAll();
    }

    //update
    @PutMapping("/update/{id}")
    public String update(@PathVariable(value = "id") int id, Model model) {
        SucursalDTO dto = sucursalService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", dto);
        return "update-user";
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id){

        sucursalService.deleteById(id);
        return "redirect:/sucursal/";

    }

}