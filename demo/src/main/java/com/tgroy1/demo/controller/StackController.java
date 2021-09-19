package com.tgroy1.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgroy1.demo.service.CustomStack;

@RestController
@RequestMapping("/stack")
public class StackController {

	@Autowired
	private CustomStack stack;

	@PostMapping("/push")
	public ResponseEntity<Object> push(@RequestParam int item) {
		try {
			stack.push(item);
			return ResponseEntity.ok().body(item);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e.getMessage());
		}
	}

	@GetMapping("/pop")
	public ResponseEntity<Object> pop() {
		try {
			int item = stack.pop();
			return ResponseEntity.ok().body(item);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e.getMessage());
		}
	}

	@GetMapping("/get")
	public ResponseEntity<Object> get() {
		try {
			int item = stack.get();
			return ResponseEntity.ok().body(item);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e.getMessage());
		}
	}

}
