package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Users;
import com.example.demo.services.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PaymentController {
	@Autowired
	UserService uServ;
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOreder() {
		Order order = null;

		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_WLdhqgiA438Ivw", "T5b7PmQFhYcNOYeahK2Ps3BI");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", 50000);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1", "Tea, Earl Grey, Hot");
			orderRequest.put("notes", notes);

			order = razorpay.orders.create(orderRequest);
		} catch (Exception e) {
			System.out.println("exception while creating order");
		}
		return order.toString();

	}

	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam String orderId, @RequestParam String paymentId,
			@RequestParam String signature) {
		try {
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_WLdhqgiA438Ivw", "T5b7PmQFhYcNOYeahK2Ps3BI");

			String verificationdata = orderId + "|" + paymentId;
			boolean isValidSignature = Utils.verifySignature(verificationdata, signature, "T5b7PmQFhYcNOYeahK2Ps3BI");
			return isValidSignature;
		} catch (RazorpayException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	@GetMapping("payment_success")
	public String paymentSucces(HttpSession session) {
		String email= (String) session.getAttribute("email");
		Users user=uServ.getObject(email);
		user.setPremium(true);
		uServ.updateUser(user);
		return "login";
	}
	
	@GetMapping("payment_failure")
	public String paymentFailure() {
		return "login";
	}
	
	

}
