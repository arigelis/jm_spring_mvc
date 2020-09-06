package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam("locale") String locale) {
        if (locale.equalsIgnoreCase("ru")) {
            model.addAttribute("message", "МАШИНЫ");
        } else {
            model.addAttribute("message", "CARS");
        }
        model.addAttribute("cars", carService.getCars());
        return "cars_list";
    }

    @RequestMapping(value = "/new")
    public String saveCar(Map<String, Object> model) {//@ModelAttribute Car car, BindingResult errors, Model model) {
        Car car = new Car();
        model.put("car", car);
        return "save_car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/";
    }
}