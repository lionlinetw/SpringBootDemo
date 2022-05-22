package com.boot.example.controller;

import com.boot.example.service.BootService;
import com.boot.example.vo.DoCrudVo;
import com.boot.example.vo.ReadVo;
import com.boot.example.vo.ResultVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rest")
public class BootRestController {

    @Autowired
    BootService bootService;

    @GetMapping("/testConnection")
    public String testConnection(HttpServletRequest request) {
        return "Rest Connection Successfully";
    }

    @GetMapping("/createNew")
    public ResultVo createNew(DoCrudVo inputVo) {
        return bootService.create(inputVo);
    }

    @GetMapping("/update")
    public ResultVo update(DoCrudVo inputVo) {
        return bootService.update(inputVo);
    }

    @GetMapping("/readAll")
    public ReadVo readAll(DoCrudVo inputVo) {
        return bootService.read(inputVo);
    }

    @GetMapping("/delete")
    public ResultVo delete(DoCrudVo inputVo) {
        return bootService.delete(inputVo);
    }


}
