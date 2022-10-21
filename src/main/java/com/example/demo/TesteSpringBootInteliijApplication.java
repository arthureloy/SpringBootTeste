package com.example.demo;

import controllers.EmpresaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import servicos.EmpresaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteSpringBootInteliijApplication {

    /**teste de arquivo properties*/
    @Value("${paginacao.quantidade_por_pagina}")
    private int qtdPaginas;

    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private EmpresaController empresaController;

    public static void main(String[] args) {
        SpringApplication.run(TesteSpringBootInteliijApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            /**teste de arquivo properties*/
          //  System.out.println("Quantidade por página: " + this.qtdPaginas);

            /**teste de criptografia de senhas*/
            //String password = "123456";
            //String encodedPassword = SenhaUtils.createBCrypt(password);
            //System.out.println("Senha codificada: " + encodedPassword + " Senha válida? " + SenhaUtils.isValidPassword(password, encodedPassword));

            /**teste de sercice*/
            //empresaService.testService();
        };
    }

}
