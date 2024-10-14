package com.empresa.empresa.infrastructure.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class incioControllers {

    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }
    
    @GetMapping("/gestion")
    public String gestion(Model model){
        return "gestion";
    }
    @GetMapping("/users")
    public String users(Model model){
        return "users";
    }
   
    @GetMapping("/login")
    public String login() {
        return "login"; 
    }

    @GetMapping("/servicioinsumo")
    public String servicioinsumo(Model model){
        return "servicioinsumo";
    }

    @GetMapping("/registrarcliente")
    public String registrarcliente(Model model){
        return "registrarcliente";
    }

    @GetMapping("/registrarempleado")
    public String registrarempleado(Model model){
        return "registrarempleado";
    }

    
    @GetMapping("/ordenesasignadas")
    public String ordenesasignadas(Model model){
        return "ordenesasignadas";
    }

    @GetMapping("/crearordenes")
    public String crearordenes(Model model){
        return "crearordenes";
    }
    @GetMapping("/visualizarcliente")
    public String visualizarcliente(Model model){
        return "visualizarcliente";
    }


    @GetMapping("/visualizarproveedores")
    public String visualizarproveedores(Model model){
        return "visualizarproveedores";
    }



    @GetMapping("/Visulizarinsumos")
    public String Visulizarinsumos(Model model){
        return "Visulizarinsumos";
    }
    @GetMapping("/VisualizarInsumosProveedores")
    public String VisualizarInsumosProveedores(Model model){
        return "VisualizarInsumosProveedores";
    }
    @GetMapping("/caso11")
    public String caso11(Model model){
        return "caso11";
    }
    @GetMapping("/caso12")
    public String caso12(Model model){
        return "caso12";
    }
    @GetMapping("/caso13")
    public String caso13(Model model){
        return "caso13";
    }
    @GetMapping("/caso14")
    public String caso14(Model model){
        return "caso14";
    }
    @GetMapping("/caso15")
    public String caso15(Model model){
        return "caso15";
    }
    @GetMapping("/caso16")
    public String caso16(Model model){
        return "caso16";
    }
    @GetMapping("/caso17")
    public String caso17(Model model){
        return "caso17";
    }
    @GetMapping("/caso18")
    public String caso18(Model model){
        return "caso18";
    }
    @GetMapping("/caso19")
    public String caso19(Model model){
        return "caso19";
    }
    @GetMapping("/caso20")
    public String caso20(Model model){
        return "caso20";
    }
    @GetMapping("/caso21")
    public String caso21(Model model){
        return "caso21";
    }
    
}

