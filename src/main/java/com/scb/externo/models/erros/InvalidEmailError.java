package com.scb.externo.models.erros;

public class InvalidEmailError {
    private String id;
    private int status;
    private String mensagem;
    
    

    public InvalidEmailError(String id, int status, String mensagem) {
        this.id = id;
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
