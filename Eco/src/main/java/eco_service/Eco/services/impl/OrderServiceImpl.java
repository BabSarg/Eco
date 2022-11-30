package eco_service.Eco.services.impl;

import eco_service.Eco.dtos.EcoServiceDTO;
import eco_service.Eco.dtos.OrderDTO;
import eco_service.Eco.dtos.RatingResponseDto;
import eco_service.Eco.exceptions.ErrorResponse;
import eco_service.Eco.mappers.OrderMapper;
import eco_service.Eco.models.Order;
import eco_service.Eco.repositories.OrderRepository;
import eco_service.Eco.response.Response;
import eco_service.Eco.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Response<ErrorResponse, OrderDTO> add(OrderDTO orderDTO) {
        Order savedOrder = orderRepository.save(orderMapper.toEntity(orderDTO));
        return new Response<>(null, orderMapper.toDTO(savedOrder), OrderDTO.class.getSimpleName());
    }

    @Override
    public Response<ErrorResponse, List<OrderDTO>> getAll() {
        List<Order> orders = orderRepository.findAll();
        return new Response<>(null, orderMapper.toDTO(orders), EcoServiceDTO.class.getName());
    }

    @Override
    public Response<ErrorResponse, List<OrderDTO>> getByEcoServiceId(Long id) {
        List<Order> orders = orderRepository.findByEcoService_Id(id);
        return new Response<>(null,orderMapper.toDTO(orders),RatingResponseDto.class.getSimpleName());

    }

    @Override
    public Response<ErrorResponse, OrderDTO> updateStatus(Long orderId, String status) {
        Order order=orderRepository.findById(orderId).orElse(null);
        status=status.toUpperCase();
        switch(status){
            case "APPROVED": order.setStatus(Order.Status.APPROVED);break;
            case "REVIEW": order.setStatus(Order.Status.REVIEW);break;
            case "REJECTED": order.setStatus(Order.Status.REJECTED);break;
            case "FULFILLED": order.setStatus(Order.Status.FULFILLED);break;
            default: order.setStatus(Order.Status.OPEN);break;
        }
        Order savedOrder = orderRepository.save(order);
        return new Response<>(null, orderMapper.toDTO(savedOrder), OrderDTO.class.getSimpleName());
    }

}
