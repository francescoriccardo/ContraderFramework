package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View
{
    private UserService userService;
    private String mode;
    private String role;
    private String firstname;

    public UserView()
    {
        this.userService = new UserService();
    }

    @Override
    public void showResults(Request request)
    {
        mode=(String)request.get("mode");
        if(mode.equals("allUser"))
        {
            role= (String)request.get("role");
            firstname=(String) request.get("firstname");
        }
    }

    @Override
    public void showOptions()
    {
        switch (mode)
        {
            case "sigIn":
            {
                System.out.println("Registrazione");
                System.out.println("Inserisci l'email");
                String username=getInput();
                System.out.println("Inserisci password");
                String password=getInput();
                System.out.println("Inserisci il nome");
                String firstname=getInput();
                System.out.println("Inserisci il cognome");
                String lastname=getInput();
                System.out.println("Inserisci la data di nascita");
                String dateofbirth=getInput();
                System.out.println("Inserisci il codice fiscale");
                String fiscalcode=getInput();
                System.out.println("Inserisci la regione sociale");
                String businessname=getInput();
                System.out.println("Inserisci la partita iva");
                String vat=getInput();
                System.out.println("Inserisci il comune");
                String municipality=getInput();
                System.out.println("Inserisci il cap");
                String post=getInput();
                System.out.println("Inserisci la citta");
                String city=getInput();
                System.out.println("Inserisci l'indirizzo");
                String address=getInput();
                System.out.println("Inserisci il telefono");
                String telephone=getInput();
                userService.insertUser(new User(null,username,password,firstname,lastname,dateofbirth,fiscalcode,businessname,vat,municipality,post,city,address,telephone,""));

            }break;
            case "allUser":
            {
                List<User> users = userService.getAllUser();
                System.out.println("----- Utenti registrati -----");
                System.out.println();
                users.forEach(user -> System.out.println(user));
            }break;
        }
    }

    @Override
    public String getInput()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public void submit()
    {
        switch (mode)
        {
            case "sigIn":
            {
                MainDispatcher.getInstance().callView("Access", null);
            }
            break;
            case "allUser":
            {
                Request request= new Request();
                request.put("role", role);
                request.put("firstname", firstname);
                MainDispatcher.getInstance().callView("Home",request);
            }
        }
    }
}
