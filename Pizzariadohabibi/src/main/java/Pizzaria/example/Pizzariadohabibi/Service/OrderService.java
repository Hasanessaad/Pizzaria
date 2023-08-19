package Pizzaria.example.Pizzariadohabibi.Service;

import Pizzaria.example.Pizzariadohabibi.DTO.OrderDto;
import Pizzaria.example.Pizzariadohabibi.Entity.Order;
import Pizzaria.example.Pizzariadohabibi.Repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<OrderDto> getAllOrdersAsDTO() {
        List<Order> ordersList = repository.findAll();
        return ordersList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrderDto> getOrdersDTOById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO);
    }

    public OrderDto createOrders(OrderDto orderDto) {
        Order orders = convertToEntity(orderDto);
        Order createdOrder = repository.save(orders);
        return convertToDTO(createdOrder);
    }

    public OrderDto updateOrders(OrderDto orderDto) {
        Order orders = convertToEntity(orderDto);
        Order updatedOrder = repository.save(orders);
        return convertToDTO(updatedOrder);
    }

    public void deleteOrders(Long id) {
        repository.deleteById(id);
    }

    private OrderDto convertToDTO(Order order) {
        OrderDto ordersDTO = new OrderDto();
        ordersDTO.setPayment(order.getPayment());
        ordersDTO.setDescription(order.getDescription());
        ordersDTO.setItems(order.getItems());
        return ordersDTO;
    }

    private Order convertToEntity(OrderDto ordersDTO) {
        Order orders = new Order();
        orders.setPayment(ordersDTO.getPayment());
        orders.setDescription(ordersDTO.getDescription());
        orders.setItems(ordersDTO.getItems()); // Assuming this method exists in OrdersDTO
        return orders;
    }
}