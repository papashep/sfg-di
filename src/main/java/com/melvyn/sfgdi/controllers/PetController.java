package com.melvyn.sfgdi.controllers;

import com.melvyn.sfgdi.services.PetService;
import org.springframework.stereotype.Controller;

/**
 * Created by Melvyn on 12/Aug/2020
 */
@Controller
public class PetController {

    private final PetService petService;

    public PetController (PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
