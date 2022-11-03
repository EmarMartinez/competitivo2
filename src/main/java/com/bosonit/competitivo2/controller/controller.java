package com.bosonit.competitivo2.controller;

import com.bosonit.competitivo2.infraestructure.ControllerObjectService;
import com.bosonit.competitivo2.model.ControllerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;

@RestController
public class controller {
    @Autowired
    ControllerObjectService service;

    @GetMapping(value="**", headers = "Accept=application/json")
    public ControllerObject entryOther(HttpServletRequest request) {
        String path = request.getRequestURI();
        String params = request.getQueryString();
        String origen = request.getRemoteAddr();

        return service.returnControllerObject(path, params, origen, request);

    }

    @GetMapping({"/","one"})

    public String entryOne() {
        return "entrada uno";
    }

    @GetMapping(value={"/salta"}) public String entryJump( ) {

        return "he ido a Jump";

    }

    @PostMapping("**")
    public String nombreModificado(HttpServletRequest request, @RequestBody String texto) {
        return service.returnBodyModificado(request, texto);
    }

    @PostMapping("/modificarbody")
    public String modificarNombre(@RequestBody String texto) {
        return texto+"MODIFICADO";
    }


}
