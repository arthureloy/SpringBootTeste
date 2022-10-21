package controllers;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/teste")
public class EmpresaController {

   @GetMapping(value = "/{nome}")
    public String teste(@PathVariable("nome") String nome){
       return "olá" + nome;
   }

}
