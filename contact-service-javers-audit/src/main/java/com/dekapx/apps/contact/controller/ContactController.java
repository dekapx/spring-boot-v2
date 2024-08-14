package com.dekapx.apps.contact.controller;

import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.contact.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @Operation(summary = "Find Contact by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Contact",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ContactModel.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Contact with ID [x] not found.", content = @Content)
    })
    @GetMapping(value = "/contact/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactModel> findContactById(@PathVariable Long id) {
        log.info("Find Contact for ID [{}]", id);
        final ContactModel contact = this.contactService.findById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @Operation(summary = "Find Contacts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Contacts",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ContactModel.class))
                    }),
            @ApiResponse(responseCode = "204", description = "No Content.", content = @Content)
    })
    @GetMapping(value = "/contacts",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContactModel>> findAll() {
        log.info("Find all contacts");
        final List<ContactModel> contacts = this.contactService.findAll();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @Operation(summary = "Create new contact", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New Contact created",
                    content = @Content(schema = @Schema(implementation = ContactModel.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Contact already exists"),
            @ApiResponse(responseCode = "405", description = "Validation exception")})
    @PostMapping(value = "/contact/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactModel> create(@Valid @RequestBody ContactModel contactModel) {
        log.info("Create new contact...");
        return new ResponseEntity<ContactModel>(this.contactService.save(contactModel), HttpStatus.OK);
    }

    @Operation(summary = "Update an existing contact", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Contact with ID [x] not found."),
            @ApiResponse(responseCode = "405", description = "Validation exception")})
    @PutMapping(value = "/contact/update/{id}",
             consumes = MediaType.APPLICATION_JSON_VALUE,
             produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactModel> update(@PathVariable Long id, @Valid @RequestBody ContactModel contactModel) {
        log.info("Update contact for ID [{}]...", id);
        return new ResponseEntity<>(this.contactService.update(id, contactModel), HttpStatus.OK);
    }

    @Operation(summary = "Deletes a contact", description = "", tags = {"contact"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Contact not found")})
    @DeleteMapping(path = "/contacts/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("Delete contact for ID [{}]...", id);
        this.contactService.delete(id);
        return new ResponseEntity<>(String.format("Contact id [%s] removed successfully...", id), HttpStatus.OK);
    }
}
