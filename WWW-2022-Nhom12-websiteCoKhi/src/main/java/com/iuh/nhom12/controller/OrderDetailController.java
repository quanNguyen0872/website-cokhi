package com.iuh.nhom12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iuh.nhom12.model.Customer;
import com.iuh.nhom12.model.Email;
import com.iuh.nhom12.model.Order;
import com.iuh.nhom12.model.OrderDetail;
import com.iuh.nhom12.model.Product;
import com.iuh.nhom12.service.CustomerService;
import com.iuh.nhom12.service.OrderDetailService;
import com.iuh.nhom12.service.OrderService;
import com.iuh.nhom12.service.ProductService;
import com.iuh.nhom12.util.EmailUtils;
import com.iuh.nhom12.util.UserUtils;

@Controller
public class OrderDetailController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/saveOrderDetail")
	public String saveOrderDetail(@RequestParam("productId") int productId) {
		String username = UserUtils.getUserName();
		System.out.println(username);
		Product product = productService.findById(productId);
		Customer customer = customerService.findByUsername(username);

		if (orderService.findByCustomerId(customer.getId(), 1) == null) {
			Order order = new Order();
			order.setCustomer(customer);
			order.setStatus(1);
			orderService.saveOrder(order);
			Order order1 = orderService.findByCustomerId(customer.getId(), 1);
			OrderDetail orderDetail = new OrderDetail(order1, product, 1);
			orderDetailService.saveOrderDetail(orderDetail);
			
		} else {
			Order order = orderService.findByCustomerId(customer.getId(), 1);
			List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(order.getId());

			if (!orderDetails.isEmpty()) {
				for (OrderDetail tempOrderDetail : orderDetails) {
					if (product.getName().equals(tempOrderDetail.getProduct().getName())) {
						int temp = tempOrderDetail.getQuantity() + 1;
						tempOrderDetail.setQuantity(temp);
						orderDetailService.saveOrderDetail(tempOrderDetail);
						return "redirect:/showShopPage"; 
					} else {
						OrderDetail orderDetail = new OrderDetail(order, product, 1);
						orderDetailService.saveOrderDetail(orderDetail);
					}
				}
			}
		}
		return "redirect:/showShopPage";

	}

	@GetMapping("/showCartPage")
	public String showCartPage(Model model) {
		String username = UserUtils.getUserName();
		Customer customer = customerService.findByUsername(username);
		try {
			Order order = orderService.findByCustomerId(customer.getId(), 1);
			if (order.getStatus() == 1) {
				List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(order.getId());
				model.addAttribute("orderDetails", orderDetails);
			} else {
				List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
				model.addAttribute("orderDetails", orderDetails);
			}
		} catch (Exception e) {
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			model.addAttribute("orderDetails", orderDetails);
		}
		return "page/cart-page";
	}

	@GetMapping("/deleteOrderDetail")
	public String deleteOrderDetail(@RequestParam("orderId") int orderId, @RequestParam("productId") int productId) {
		orderDetailService.deleteOrderDetail(orderId, productId);
		if(orderDetailService.findAllByOrderId(orderId).isEmpty()) {
			orderService.deleteById(orderId);
		}
		return "redirect:/showCartPage";
	}
	
	@GetMapping("/showShopPage")
	public String showShopPage(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		return "page/shop-page";
	}
	
	@GetMapping("/showProductDetail")
	public String showProductDetail(@RequestParam("productId") int productId, Model model) {
		Product product = productService.findById(productId);
		model.addAttribute("product", product);
		return "page/detail-product-page";
	}
	
	@GetMapping("/sendOrder")
	public String sendOrder(@RequestParam("addressDelivery") String addressDelivery, Model model) {
		String username = UserUtils.getUserName();
		Customer customer = customerService.findByUsername(username);
		Order order = orderService.findByCustomerId(customer.getId(), 1);
		order.setStatus(0);
		order.setAddressDelivery(addressDelivery);
		orderService.saveOrder(order);
		
		Email theEmail = new Email();
		theEmail.setFrom("nhom12www@gmail.com");
		theEmail.setFromPassword("yourpassword");
		theEmail.setTo(customer.getEmail());
		theEmail.setSubject("Thông tin đơn hàng");
		
		StringBuilder sb = new StringBuilder();
		sb.append("Kính gửi khách hàng ").append(customer.getLastName()+" "+customer.getFirstName()).append("<br />");
		sb.append("Cảm ơn bạn đã lựa chọn Cơ khí Q&L <br />");
		sb.append("Địa chỉ giao hàng " + order.getAddressDelivery()).append("<br />");
		sb.append("Ngày đặt hàng " + order.getOrderDate()).append("<br />");
		sb.append("Tổng tiền " + getTotal(order)).append("<br />");	
		sb.append("Regards<br/>");
		sb.append("Administrator");
		
		theEmail.setContent(sb.toString());
		EmailUtils.send(theEmail);
		
		model.addAttribute("order", order);
		model.addAttribute("total", getTotal(order));
		
		List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(order.getId());
		model.addAttribute("orderDetails", orderDetails);
		
		return "page/detail-receipt-page";
	}
	
	private double getTotal(Order order) {
		List<OrderDetail> orderDetails = orderDetailService.findAllByOrderId(order.getId());
		double total = 0;
		for (OrderDetail orderDetail : orderDetails) {
			total += orderDetail.getUnitPrice();
		}
		return total;
	}
	
	@GetMapping("/showReceiptList")
	public String showReceiptList(Model model) {
		String username = UserUtils.getUserName();
		Customer customer = customerService.findByUsername(username);
		List<Order> orders = orderService.findAllByCustomerId(customer.getId(), 0);	
		
		
		double total = 0;

		for (Order order : orders) {
			total = getTotal(order);
			order.setTotal(total);
		}
		
		model.addAttribute("orders", orders);
		
		return "page/receipt-page";
	}

}
