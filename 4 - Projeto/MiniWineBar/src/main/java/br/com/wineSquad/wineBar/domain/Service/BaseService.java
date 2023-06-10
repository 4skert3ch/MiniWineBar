package main.java.br.com.wineSquad.wineBar.domain.Service;

import main.java.br.com.wineSquad.wineBar.domain.connection.ConnectionFactory;

public abstract class BaseService {
    protected ConnectionFactory connection;

    public BaseService() {
        this.connection = new ConnectionFactory();
    }

}
