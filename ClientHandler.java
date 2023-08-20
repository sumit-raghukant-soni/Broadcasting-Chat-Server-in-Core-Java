import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientusername;

    //Constructor
    public ClientHandler(Socket socket){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clientusername = bufferedReader.readLine();
            clientHandlers.add(this);
            broadcastMessage("SERVER " + clientusername + " has entered the chat!");
        } catch(IOException e){
            closeEveryThing(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run(){
        String messagefromclient;
        
        while(socket.isConnected()){
            try{
                messagefromclient = bufferedReader.readLine();
                broadcastMessage(messagefromclient);
            } catch (IOException e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    public void broadcastMessage(String messageTosend){
        for(ClientHandler clientHandler : clientHandlers){
            try{
                if(!clientHandler.clientusername.equals(clientusername)){
                    clientHandler.bufferedWriter.write(messageTosend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch(IOException e){
                closeEveryThing(socket, bufferedReader, bufferedWriter);
            }
        }
    }
    
    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER :" + clientusername + " has left the chat!");
    }

    public void closeEveryThing(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
