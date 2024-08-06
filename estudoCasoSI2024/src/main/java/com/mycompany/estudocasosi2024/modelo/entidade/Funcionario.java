/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estudocasosi2024.modelo.entidade;

import java.util.Calendar;

/**
 *
 * @author tulio
 */
public class Funcionario {
    
    private Integer codigoFuncionario;
    private String nomeFuncionario;
    private Double salarioFuncionario;
    private Calendar nascimentoFuncionario;
    private Cidade cidadeFuncionario = new Cidade();

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(Double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public Calendar getNascimentoFuncionario() {
        return nascimentoFuncionario;
    }

    public void setNascimentoFuncionario(Calendar nascimentoFuncionario) {
        this.nascimentoFuncionario = nascimentoFuncionario;
    }

    public Cidade getCidadeFuncionario() {
        return cidadeFuncionario;
    }

    public void setCidadeFuncionario(Cidade cidadeFuncionario) {
        this.cidadeFuncionario = cidadeFuncionario;
    }
    
    
    
}