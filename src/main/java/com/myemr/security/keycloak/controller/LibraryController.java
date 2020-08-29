package com.myemr.security.keycloak.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myemr.security.keycloak.repository.BookRepository;

@Controller
public class LibraryController {

	private final HttpServletRequest httpRequest;
	private final BookRepository bookRepository;
	
	@Autowired
	public LibraryController(HttpServletRequest httpRequest, BookRepository bookRepository) {
		super();
		this.httpRequest = httpRequest;
		this.bookRepository = bookRepository;
	}
	
	@GetMapping(value="/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping(value="/books")
	public String getBooks(Model model) {
		configCommonAttributes(model);
		model.addAttribute("books", bookRepository.readAll());
		return "books";
	}
	
	@GetMapping(value="/manager")
	public String getManager(Model model) {
		configCommonAttributes(model);
		model.addAttribute("books", bookRepository.readAll());
		return "manager";
	}
	
	@GetMapping(value="/logout")
	public String logout() throws ServletException {
		httpRequest.logout();
		return "redirect:/";
	}
	
	private void configCommonAttributes(Model model) {
		var a = getKeycloakSecurityContext();
		var token= a.getIdToken();
		var name = token.getGivenName();
		model.addAttribute("name", name);
	}
	
	/**
	 * The KeycloakSecurityContext provides access to several pieces of information
	 * contained in the security token, such as user profile information.
	 */
	private KeycloakSecurityContext getKeycloakSecurityContext() {
		return (KeycloakSecurityContext) httpRequest.getAttribute(KeycloakSecurityContext.class.getName());
	}
}
