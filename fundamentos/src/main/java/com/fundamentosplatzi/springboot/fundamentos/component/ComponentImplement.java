package com.fundamentosplatzi.springboot.fundamentos.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo");
    }
    public void dividir() {
        try {
            int num = 10/0;
            log.debug("El numero es: " + num);
        }
        catch (Exception e) {
            log.error("Esto es un error al divir por 0 " + e.getMessage());
        }
    }
}
