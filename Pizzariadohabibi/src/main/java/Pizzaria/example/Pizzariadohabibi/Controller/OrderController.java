package Pizzaria.example.Pizzariadohabibi.Controller;

import Pizzaria.example.Pizzariadohabibi.DTO.OrderDto;
import Pizzaria.example.Pizzariadohabibi.Repository.OrderRepository;
import Pizzaria.example.Pizzariadohabibi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> ordersDTOList = service.getAllOrdersAsDTO();
        return ResponseEntity.ok(ordersDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrdersById(@PathVariable Long id) {
        return service.getOrdersDTOById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<OrderDto> createOrders(@RequestBody OrderDto ordersDTO) {
        OrderDto createdOrderDTO = service.createOrders(ordersDTO);
        return ResponseEntity.ok(createdOrderDTO);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<OrderDto> updateOrders(@PathVariable Long id, @RequestBody OrderDto ordersDTO) {
        if (!id.equals(ordersDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        OrderDto updatedOrderDTO = service.updateOrders(ordersDTO);
        return ResponseEntity.ok(updatedOrderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
        service.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }
}

