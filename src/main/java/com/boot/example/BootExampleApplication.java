package com.boot.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//額外指定掃哪個folder, 因為spring boot掃元件的基礎是其他檔案需在@SpringBootApplication開始以內的階層
//@SpringBootApplication(scanBasePackages="controller")

@SpringBootApplication
public class BootExampleApplication {
    

	public static void main(String[] args) {
		SpringApplication.run(BootExampleApplication.class, args);		

	}

}
