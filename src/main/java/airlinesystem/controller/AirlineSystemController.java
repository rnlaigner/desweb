package airlinesystem.controller;

//import airlinesystem.login.Login;
import airlinesystem.model.entity.Route;
import airlinesystem.model.entity.Seat;
import airlinesystem.model.entity.User;
import airlinesystem.model.exception.ExistantUsernameException;
import airlinesystem.model.exception.InvalidFlightOptionException;
import airlinesystem.model.exception.WrongPasswordException;
import airlinesystem.model.exception.WrongUsernameException;
import airlinesystem.persistence.SimulateDB;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirlineSystemController 
{
    SimulateDB database = new SimulateDB();
    
    public void initLoginScreen()
    {
        boolean exit = false;
        String input;
        Scanner scanner = new Scanner(System.in);
        
        do
        {
            System.out.println("Selecione a opcao desejada");
            System.out.println("1 - Realizar login");
            System.out.println("2 - Criar uma conta");
            System.out.println("3 - Sair do sistema");
            input = scanner.nextLine();
            
            switch(input)
            {
                case "1":
                {
                    try
                    {
                        User user = validateLogin(scanner);
                        System.out.println("Login realizado com sucesso");
                        initMainScreen(scanner,user);
                    }
                    catch(WrongPasswordException | WrongUsernameException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "2":
                {
                    try
                    {
                        //User user = createAccount(scanner);
                        System.out.println("Conta criada com sucesso");
                        initMainScreen(scanner, null);
                    }
                    catch (ExistantUsernameException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case "3":
                {
                    System.out.println("Saindo do sistema...");
                    exit = true;
                    break;
                }
                default: 
                {    System.out.println("Escolha uma opcao valida");
                     break;
                }
            }    
            
        }
        while(exit == false);
    }
    
    public User validateLogin(Scanner scanner)
    { 
//        String username;
//        String password;
//        
//        System.out.println("Entre com seu nome de usuario");
//        username = scanner.nextLine();
//        System.out.println("Entre com sua senha");
//        password = scanner.nextLine();
        
        //Login login = new Login(username, password);
        
        //return login.authenticate(database);
        return new User();
    }
    
    /*
    public User createAccount(Scanner scanner)
    {
        System.out.println("Entre com seu username");
        String username = scanner.nextLine();
        System.out.println("Entre com sua senha");
        String password = scanner.nextLine();
        
        return database.createAccount(username, password);
    }
    */
    
    public static void showRoute(Route route)
    {
        System.out.print("Numero do voo ");
        System.out.println(route.getRouteId());

        System.out.print("Origem ");
        System.out.println(route.getOrigin());

        System.out.print("Destino ");
        System.out.println(route.getDestiny());

        System.out.print("Data de Embarque ");
        System.out.println(route.getFlightTime());

        System.out.print("Aterrisagem ");
        System.out.println(route.getLandTime());

        System.out.print("Aeronave ");
        System.out.println( route.getAirplane().getAirplaneNumber());
    }

    public void initMainScreen(Scanner scanner, User user) 
    {
        List<Route> routes; 
        
        routes = database.retrieveRoutes();
           
        boolean exit = false;
        String input;
        
        System.out.println("Iniciando o sistema de companhia aerea...");
        
        do
        {
            System.out.println("Menu principal");
            System.out.println("Escolha uma das opcoes a seguir:");
            System.out.println("1 - Listar voos disponiveis");
            System.out.println("2 - Procurar por um voo ");
            System.out.println("3 - Realizar a compra de um voo");
            System.out.println("4 - Realizar check-in");
            System.out.println("5 - Listar seus voos");
            System.out.println("6 - Editar sua conta");
            System.out.println("7 - Sair");
            input = scanner.nextLine();
            
            switch(input)
            {
                case "1":
                {
                    for (Route route : routes)
                    {
                        showRoute(route);
                    }
                    break;
                }
                case "2":
                {
                    List<List<Route>> flights = searchFlight(scanner, routes);
                    System.out.println("Voce deseja adquirir algum voo?");
                    boolean resp = scanner.nextLine().equals("s") ? true : false;
                    if(resp)
                    {
                        boolean leave = false;
                        while(!leave)
                        {
                            try
                            {
                                buyFlight(scanner, flights, user);
                                System.out.println("Deseja realizar a compra de outro voo? y/n");
                                leave = scanner.nextLine() == "y" ? true : false;
                            }
                            catch(InvalidFlightOptionException e)
                            {
                                System.out.println(e.getMessage());
                                System.out.println("Deseja tentar realizar a compra de um voo novamente? y/n");
                                leave = scanner.nextLine() == "y" ? true : false;
                            }
                        }
                    }
                    break;
                }
                case "3":
                {
                    List<List<Route>> flights = searchFlight(scanner,routes);
                    boolean leave = false;
                    while(!leave)
                    {
                        try
                        {
                            //metodo que compra
                            buyFlight(scanner, flights, user);
                            System.out.println("Deseja realizar a compra de outro voo? y/n");
                            leave = scanner.nextLine() == "y" ? true : false;
                        }
                        catch(InvalidFlightOptionException e)
                        {
                            System.out.println(e.getMessage());
                            System.out.println("Deseja tentar realizar a compra de um voo novamente? y/n");
                            leave = scanner.nextLine() == "y" ? true : false;
                        }
                    }
                    break;
                }
                case "7":
                {
                    System.out.println("Realizando o logout...");
                    exit = true;
                    break;
                }
                default: 
                {    System.out.println("Escolha uma opcao valida");
                     break;
                }
            }
        }
        while(exit != true);
    }   
    
    //o ideal eh que rotas com todas as cadeiras ocupadas nao aparecam para o passageiro
    private void buyFlight(Scanner scanner, List<List<Route>> flights, User user) 
            throws InvalidFlightOptionException
    {
        int option;
        
        System.out.println("Escolha a opcao de voo ");
        option = Integer.parseInt(scanner.nextLine());
        
        //verificar se opcao de fato existe
        if (option < 1 || option > (flights.size() + 1))
        {
            throw new InvalidFlightOptionException();
        }
        
        List<Route> selectedRoutes = flights.get(option - 1);
        
        //para cada rota escolhida, devo selecionar um assento
        for (Route route : selectedRoutes)
        {
            boolean exit = false;
            while(!exit)
            {
                try
                {
                    Seat seat = selectAvailableSeat(scanner, route);
                    
                    System.out.print(seat.getAirplaneSeat());
                }
                catch (InvalidFlightOptionException e)
                {
                    System.out.println(e.getMessage());
                    System.out.println("Voce deseja escolher novamente? y/n");
                    exit = scanner.nextLine() == "y" ? true : false;
                }
            }
        }
        
//        RouteFlight newRouteFlight = new RouteFlight()
//        
//        Flight newFlight = new Flight()

        //Ao fim da selecao de assentos, calcular o preco baseado no preco do voo + acrescimo do assento
    }
    
    //esse metodo deve permitir sincronismo
    //uma vez selecionado um, outro usuario nao pode selecionar o mesmo assento concomitantemente
    private Seat selectAvailableSeat(Scanner scanner, Route route)
            throws InvalidFlightOptionException
    {
        List<Seat> availableSeats = getAvailableSeats(route);
        
        //exibir opcoes de escolha
        int index = 1;
        for(Seat seat : availableSeats)
        {
            System.out.println("Opcao "+index);
            System.out.print("Categoria do assento: ");
            System.out.println(seat.getCategory());
            System.out.print("Assento: ");
            System.out.println(seat.getAirplaneSeat());
        }
        
        int option;
        
        System.out.println("Escolha a opcao de assento ");
        option = Integer.parseInt(scanner.nextLine());
        
        //verificar se opcao de fato existe
        if (option < 1 || option > (availableSeats.size() + 1))
        {
            throw new InvalidFlightOptionException();
        }
        
        return route.getAirplane().getSeats().get(0);
    }
    
    private List<Seat> getAvailableSeats(Route route)
    {
        List<Seat> availableSeats = new ArrayList<Seat>();
        
        for (Seat seat : route.getAirplane().getSeats())
        {
            //if it is available
            if(isSeatAvailable(route, seat))
            {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }
    
    private boolean isSeatAvailable(Route route, Seat seat)
    {
        // essa consulta ao consulta teria de trazer apenas os voos comprados para essa rota,
        //e nao todos
//        List<Flight> flights = database.getBoughtFlights();
        
//        for(Flight flight : flights)
//        {
//            for(RouteFlight routeFlight : flight.getRoutes())
//            {
//                if(routeFlight.getRoute().equals(route) && routeFlight.getSeat().equals(seat))
//                {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    private List<List<Route>> searchFlight(Scanner scanner, List<Route> routes) 
    {
        //Pair<String,int> pair = new Pair("erick",2);
        
        List<List<Route>> flights = new ArrayList<List<Route>>();
        
        String origin;
        String destiny;
        //String date;
        String startDate;
        String endDate;
        
        System.out.println("Digite a origem");
        origin = scanner.nextLine();
        
        System.out.println("Digite o destino");
        destiny = scanner.nextLine();
        
        System.out.println("Digite a data de ida do voo");
        startDate = scanner.nextLine();
        
        System.out.println("Digite a data de volta do voo");
        endDate = scanner.nextLine();
        
        List<Route> outboundFlights = database.getRoutes(origin,destiny,startDate,routes);
        List<Route> backFlights = database.getRoutes(destiny,origin,endDate,routes);
        
        //Exibir voos (que podem ser conjuntos de rotas)
        System.out.println("Exibindo os voos de ida");
        int index = 1;
        for (Route outboundFlight : outboundFlights)
        {
            System.out.println("Opcao "+index);
            showRoute(outboundFlight);
            index++;
        }
        System.out.println("Exibindo os voos de volta");
        for (Route backFlight : backFlights)
        {
            System.out.println("Opcao "+index);
            showRoute(backFlight);
            index++;
        }
        
        flights.add(outboundFlights);
        flights.add(backFlights);
        
        return flights;
    }
}