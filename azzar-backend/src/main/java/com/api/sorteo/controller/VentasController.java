package com.api.sorteo.controller;

import com.api.sorteo.controller.VentasControllerDecorator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/azzar/ventas")
public class VentasController extends VentasControllerDecorator {
}
