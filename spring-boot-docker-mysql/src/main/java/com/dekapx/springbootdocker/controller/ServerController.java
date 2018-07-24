package com.dekapx.springbootdocker.controller;

import com.dekapx.springbootdocker.dto.ServerDto;
import com.dekapx.springbootdocker.service.ServerNotFoundException;
import com.dekapx.springbootdocker.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CONFLICT;


@RestController
public class ServerController {
    @Autowired
    private ServerService serverService;

    @GetMapping(value = "/server/{id}", produces = "application/json")
    public ServerDto getServer(@PathVariable long id) {
        return serverService.find(id);
    }

    @GetMapping(value = "/servers/", produces = "application/json")
    public List<ServerDto> getServers() {
        return serverService.findAll();
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
