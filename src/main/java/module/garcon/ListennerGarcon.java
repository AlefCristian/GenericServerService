package module.garcon;

import java.io.IOException;
import java.net.Socket;

import server.Listenner;

public class ListennerGarcon extends Listenner {

    public ListennerGarcon(Socket socket) {
        super(socket);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        //deconstruct = new MessageJsonDeconstruct(message);
        try {
            if ((message = (String) input.readObject()) != null) {
                //ActionGarcon action = deconstruct.getAction();
                ActionGarcon action = ActionGarcon.CLOSECOMANDA;
                switch (action) {
                    case CLOSECOMANDA:
                        closeComanda();
                        break;
                    case GETCARDAPIO:
                        getProdutos();
                        break;
                    case GETCOMANDA:
                        getComanda();
                        break;
                    case GETPEDIDOS:
                        getPedidos();
                        break;
                    case SETPEDIDOS:
                        todoPedidos();
                        break;
                    default:
                        break;

                }
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
    //Implemente as funcoes para enviar as mensagens ao cliente

    private void getPedidos() {
        //write(new MessageJsonBuilder().putPedidos(ServiceGarcon.getComanda(deconstruct.getComanda())).builder());

    }

    private void getComanda() {
        //write(new MessageJsonBuilder().put(ServiceGarcon.getComanda(deconstruct.getComanda())).builder());

    }

    private void closeComanda() {
        //write(new MessageJsonBuilder().put(ServiceGarcon.closeComanda(deconstruct.getComanda())).builder());

    }

    private void getProdutos() {
        //write(new MessageJsonBuilder().putProdutos(ServiceGarcon.getCardapio()).builder());
    }

    private void todoPedidos() {
        //write(new MessageJsonBuilder().put(ServiceGarcon.todoPedidos(deconstruct.getComanda(), deconstruct.getPedidos())).builder());
    }

}
