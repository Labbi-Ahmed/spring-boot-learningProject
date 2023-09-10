package com.learnrestapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
	/// USING URI VERSIONING 
	/*
	 * {uri and param is :  uri pollution}
	 * header and  media type is : misuse of http headers
	 * 	caching : problem header and media type 
	 * 	not execute from browsers
	 */

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Labib Ahmed");
	}
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Labib"," Ahmed"));
	}
	
	
	/// PARAMETER VERSIONING
	
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonWithParam() {
		return new PersonV1("Labib Ahmed");
	}
	
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonWithParam() {
		return new PersonV2(new Name("Labib"," Ahmed"));
	}
	
	
	/// HEADER VERSIONING
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonWithRequestHeader() {
		return new PersonV1("Labib Ahmed");
	}
	
	@GetMapping(path="/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonWithRequestHeader() {
		return new PersonV2(new Name("Labib"," Ahmed"));
	}
	
	
	// accept header 
	@GetMapping(path="/person/accept", produces =  "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonWithAcceptHeader() {
		return new PersonV1("Labib Ahmed");
	}
	
	@GetMapping(path="/person/accept", produces =  "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonWithAcceptHeader() {
		return new PersonV2(new Name("Labib"," Ahmed"));
	}
}
