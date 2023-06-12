package br.com.wineSquad.wineBar.domain.Service;

import br.com.wineSquad.wineBar.domain.connection.ConnectionFactory;

public abstract class BaseService {
    protected static ConnectionFactory connection = new ConnectionFactory();

}
