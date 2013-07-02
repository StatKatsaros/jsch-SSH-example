public class SSHExample {
    SSHManager instance;

    public static void main(String[] args) {
        //command to be sent to remote machine
        String command = "ls -la";
        //SSH Instance... using generic user/password/server name
        instance = new SSHManager("username", "password", "server", "");
        //connect to server
        String errorMessage = instance.connect();
        if(errorMessage != null){
            System.out.println("ERROR >" + errorMessage);
        }
        
        //send command to server
        String result = instance.sendCommand(command);
        
        //close connection
        instance.close();
        
        //check what's returned... in this case .bash_history
        if (result.contains(".bash_history")){
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
            
    }
}
