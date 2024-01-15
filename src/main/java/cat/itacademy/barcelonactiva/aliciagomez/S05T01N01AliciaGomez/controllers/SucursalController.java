package cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.aliciagomez.S05T01N01AliciaGomez.model.services.SucursalService;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("titulo", "Indice");
        return "index";
    }

    //create new
    @PostMapping("/add")
    public ResponseEntity<?> create (@RequestBody Sucursal sucursal){
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.save(sucursal));
    }

    //read by id
    @GetMapping("/getOne/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") int id){
        Optional<Sucursal> sucursal = sucursalService.findById(id);

        if(!sucursal.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sucursal);
    }

    //read all
    @GetMapping("/getAll")
    public List<Sucursal> readAll() {
        return sucursalService.findAll();
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Sucursal SucursalDetails, @PathVariable(value = "id") int id) {
        Optional<Sucursal> sucursal = sucursalService.findById(id);

        if(!sucursal.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        sucursal.get().setNom(SucursalDetails.getNom());
        sucursal.get().setPais(SucursalDetails.getPais());

        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalService.save(sucursal.get()));

    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
        if(!sucursalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        sucursalService.deleteById(id);
        return ResponseEntity.ok().build();

    }

}